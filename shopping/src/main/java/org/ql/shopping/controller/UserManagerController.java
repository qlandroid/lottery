package org.ql.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service.Mode;

import org.ql.shopping.HttpUrl;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.AccountHaveException;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.Rows;
import org.ql.shopping.pojo.UserLogin;
import org.ql.shopping.pojo.UserManager;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.pojo.result.LoginResult;
import org.ql.shopping.pojo.result.MainLeftNav;
import org.ql.shopping.service.IUserClientService;
import org.ql.shopping.service.IUserManagerService;
import org.ql.shopping.util.MainNavFactroy;
import org.ql.shopping.service.IUserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserManagerController {
	private Logger logger = LoggerFactory.getLogger(UserManagerController.class);

	@Resource
	private IUserLoginService mUserService;
	@Resource
	private IUserClientService mUserClientService;
	@Resource
	private IUserManagerService mUserManagerService;

	@RequestMapping("/login")
	public String userManagerLogin() {
		return "login.jsp";
	}

	@RequestMapping(value = "/toLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result userManagerLogin(HttpServletRequest request, UserManager userParams) {
		Result result = new Result();

		String account = userParams.getAccount();
		String pw = userParams.getPw();
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(pw)) {
			result.setCode(Code.ERROR);
			result.setMessage("账号或密码不能为空");
		} else {

			UserManager userLogin = mUserManagerService.findUserOfAccount(account);

			if (userLogin == null || !pw.equals(userLogin.getPw())) {
				result.setCode(Code.ACCOUNT_OR_PW_ERROR);
			} else {
				result.setCode(Code.SUCCESS);
				LoginResult login = new LoginResult();
				login.setUrl("main.do");
				result.setData(login);
				HttpSession s = request.getSession();
				s.setAttribute("token", account);
				s.setAttribute("power", userLogin.getPower());
			}
		}
		return result;
	}

	@RequestMapping(value = "/main")
	public ModelAndView showMainView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main.jsp");
		return mav;
	}
////userService/userServiceManagerSerach.do?account=&name=&power=&phone=
	@RequestMapping("/userServiceManager")
	public ModelAndView showUserManger(HttpServletRequest request,UserManager queryUser) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/user_service_manager.jsp");
		Integer page = queryUser.getPage();
		if(queryUser.getPageSize() == null){
			queryUser.setPageSize(20);
		}
		int firstIndex ;
		if(page == null){
			firstIndex =0 ;
		}else{
			firstIndex = (page -1 ) * queryUser.getPageSize();
		}
		queryUser.setFirstIndex(new Long(firstIndex));
		List<UserManager> userList = mUserManagerService.findPage(queryUser);
		Long total = mUserManagerService.getUserTotalCount();

		total = total/ queryUser.getPageSize() +1;
		mav.addObject("total", total);
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/page/mainLeftNav")
	@ResponseBody
	public List<MainLeftNav> mainLeftNav() {
		return MainNavFactroy.getInstans().getMianNavList();
	}

	@RequestMapping("/index")
	public String index() {
		return "page/index.jsp";
	}
//userService/userServiceManagerSearch.jsp
	@RequestMapping("/userService/userServiceManagerSearch")
	public String userServiceSearch() {
		return "page/user_service_search.jsp";
	}
	@RequestMapping("/userService/userServiceManagerAdd")
	public String userServiceAdd() {
		return "page/user_service_add.jsp";
	}
	
	@RequestMapping("/userService/add")
	@ResponseBody
	 public Result userServiceAdd(UserManager userManager){
		 Result result = new Result();
		 try{
			 
			String account =  userManager.getAccount();
			UserManager acc = mUserManagerService.findUserByAccount(account);
			if(acc != null){
				throw new AccountHaveException("账号已经存在");
			}
			UserManager u = mUserManagerService.inserteUser(userManager);
			if(u == null){
				throw new LotteryException("注册失败");
			}
			result.setCode(Code.SUCCESS);
		 }catch(AccountHaveException e){
			 result.setCode(Code.ACCOUNT_HAVE);
			 result.setMessage(e.getMessage());
		 }catch(LotteryException e){
			 result.setCode(Code.ERROR);
			 result.setMessage(e.getMessage());
		 }catch(Exception e){
			 logger.error("userServiceAdd",e);
			 result.setCode(Code.ERROR);
			 result.setMessage("系统内部错误");
		 }
		 return result;
	 }
	
}
