package org.ql.shopping.controller.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.AccountHaveException;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private Logger logger = LoggerFactory.getLogger(UserServiceMangerController.class);

	private String url(String url) {
		return HttpUrl.BASE_URL + "/userService" + url;
	}

	@Resource
	private IUserServiceManagerService mUserManagerService;

	/**
	 * 查询用户，条件选择页面 userService/userServiceManagerSearch.jsp
	 * 
	 * @return
	 */
	@RequestMapping("/view/search")
	public String userServiceSearch(Model model) {
		model.addAttribute("searchUrl", url("/list"));
		return "page/user_service_search.jsp";
	}

	/**
	 * 显示添加用户页面
	 * 
	 * @return
	 */
	@RequestMapping("/view/add")
	public String userServiceAdd(Model model) {
		model.addAttribute("addUrl", url("/operate/add"));
		return "page/user_service_add.jsp";
	}

	/**
	 * 顯示修改詳情頁面
	 * 
	 * @return
	 */
	@RequestMapping("/view/change")
	public ModelAndView userServiceChange(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView();
		UserManager changeUser = mUserManagerService.findUserById(id);
		if (changeUser == null) {

		} else {
			mav.setViewName("page/user_service_change.jsp");
			mav.addObject("user", changeUser);
			mav.addObject("changeUrl", url("/operate/change"));
		}

		return mav;
	}

	/**
	 * userService/userServiceManagerSerach.do?account=&name=&power=&phone= 分页查询
	 * 
	 * @param request
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView showUserManger(HttpServletRequest request, UserManager params) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/user_service_manager.jsp");
		Long page = params.getPage();
		if (page == null || page <= 0) {
			page = 1L;
			params.setPage(page);
		}
		Integer pageSize = params.getPageSize();
		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
			params.setPageSize(pageSize);
		}
		List<UserManager> userList = mUserManagerService.findPage(params);
		Long total = mUserManagerService.getUserTotalCount(params);
		Long totlaUser = total;
		total = total / params.getPageSize() + 1;
		mav.addObject("page", page);
		mav.addObject("total", total);
		mav.addObject("userList", userList);
		mav.addObject("totalUser", totlaUser);
		mav.addObject("searchUrl", url("/list"));
		mav.addObject("searchViewUrl", url("/view/search"));
		mav.addObject("addUserViewUrl", url("/view/add"));
		mav.addObject("changeViewUrl", url("/view/change"));
		mav.addObject("deleteUrl", url("/operate/delete"));
		return mav;
	}

	@RequestMapping("/operate/add")
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
	 * 通過用戶的id進行刪除
	 * 
	 * @param request
	 * @param delUser
	 * @return
	 */
	@RequestMapping("/operate/delete")
	@ResponseBody
	public Result userDelete(HttpServletRequest request, UserManager delUser) {
		Result result = new Result();
		try {
			mUserManagerService.deleteUserById(delUser.getId());
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			ResultHintUtils.setSystemError(result);
			logger.error("userDelete", e);
		}
		return result;
	}

	@RequestMapping("/operate/change")
	@ResponseBody
	public Result changeUserDetails(HttpServletRequest request, UserManager user) {
		Result result = new Result();
		try {
			mUserManagerService.updateUser(user);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("changeUserDetails", e);
			ResultHintUtils.setSystemError(result);
		}

		return result;
	}
}
