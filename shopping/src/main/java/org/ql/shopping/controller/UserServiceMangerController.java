package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.AccountHaveException;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.UserManager;
import org.ql.shopping.service.IUserManagerService;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 客戶端用戶管理
 * 
 * @author android
 *
 */
@Controller
@RequestMapping("/userService")
public class UserServiceMangerController {
	private Logger logger = LoggerFactory
			.getLogger(UserServiceMangerController.class);

	@Resource
	private IUserManagerService mUserManagerService;

	/**
	 * 查询用户，条件选择页面
	 *userService/userServiceManagerSearch.jsp
	 * @return
	 */
	@RequestMapping("/userServiceManagerSearch")
	public String userServiceSearch() {
		return "page/user_service_search.jsp";
	}

	/**
	 * 显示添加用户页面
	 * @return
	 */
	@RequestMapping("/userServiceManagerAdd")
	public String userServiceAdd() {
		return "page/user_service_add.jsp";
	}
	/**
	 * 顯示修改詳情頁面
	 * @return
	 */
	@RequestMapping("/userServiceManagerChange")
	public ModelAndView userServiceChange(@RequestParam("id")long id) {
		ModelAndView mav = new ModelAndView();
		
		
		UserManager changeUser = mUserManagerService.findUserById(id);
		if(changeUser == null){
		}else{
			mav.setViewName("page/user_service_change.jsp");
			mav.addObject("user",changeUser);
		}
	
		return mav;
	}
	/**
	 * 通過用戶的id進行刪除
	 * @param request
	 * @param delUser
	 * @return
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Result userDelete(HttpServletRequest request,UserManager delUser){
		Result result = new Result();
		try{
			mUserManagerService.deleteUserById(delUser.getId());
			result.setCode(Code.SUCCESS);
		}catch(Exception e){
			ResultHintUtils.setSystemError(result);
			logger.error("userDelete",e);
		}
		return result;
	}

	/**
	 * userService/userServiceManagerSerach.do?account=&name=&power=&phone=
	 * 分页查询
	 * @param request
	 * @param queryUser
	 * @return
	 */
	@RequestMapping("/userServiceManager")
	public ModelAndView showUserManger(HttpServletRequest request,
			UserManager queryUser) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/user_service_manager.jsp");
		Integer page = queryUser.getPage();
		if (queryUser.getPageSize() == null) {
			queryUser.setPageSize(10);
		}
		int firstIndex;
		if (page == null) {
			page = 1;
			firstIndex = 0;
		} else {
			firstIndex = (page - 1) * queryUser.getPageSize();
		}
		queryUser.setFirstIndex(new Long(firstIndex));
		List<UserManager> userList = mUserManagerService.findPage(queryUser);
		Long total = mUserManagerService.getUserTotalCount();

		total = total / queryUser.getPageSize() + 1;
		mav.addObject("page",page);
		mav.addObject("total", total);
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/add")
	@ResponseBody
	public Result userServiceAdd(UserManager userManager) {
		Result result = new Result();
		try {

			String account = userManager.getAccount();
			UserManager acc = mUserManagerService.findUserByAccount(account);
			if (acc != null) {
				throw new AccountHaveException("账号已经存在");
			}
			UserManager u = mUserManagerService.inserteUser(userManager);
			if (u == null) {
				throw new LotteryException("注册失败");
			}
			result.setCode(Code.SUCCESS);
		} catch (AccountHaveException e) {
			result.setCode(Code.ACCOUNT_HAVE);
			result.setMessage(e.getMessage());
		} catch (LotteryException e) {
			result.setCode(Code.ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error("userServiceAdd", e);
			result.setCode(Code.ERROR);
			result.setMessage("系统内部错误");
		}
		return result;
	}

	
	/**
	 * userServiceChange
	 */
	
	@RequestMapping("/userChange")
	@ResponseBody
	public Result changeUserDetails(HttpServletRequest request,UserManager user){
		Result result = new Result();
		try{
			mUserManagerService.updateUser(user);
			result.setCode(Code.SUCCESS);
		}catch(Exception e){
			logger.error("changeUserDetails",e);
			ResultHintUtils.setSystemError(result);
		}
		
		return result;
	}
}
