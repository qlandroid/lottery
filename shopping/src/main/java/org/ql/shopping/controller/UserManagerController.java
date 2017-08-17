package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service.Mode;

import org.ql.shopping.HttpUrl;
import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.Rows;
import org.ql.shopping.pojo.UserLogin;
import org.ql.shopping.pojo.UserManager;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.pojo.result.LoginResult;
import org.ql.shopping.service.IUserClientService;
import org.ql.shopping.service.IUserManagerService;
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
@RequestMapping("/manager")
public class UserManagerController {
	private Logger logger = LoggerFactory
			.getLogger(UserManagerController.class);

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
	public Result userManagerLogin(HttpServletRequest request,
			UserManager userParams) {
		Result result = new Result();

		
		String account = userParams.getAccount();
		String pw = userParams.getPw();
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(pw)) {
			result.setCode(Code.ERROR);
			result.setMessage("账号或密码不能为空");
		} else {

			UserManager userLogin = mUserManagerService
					.findUserOfAccount(account);

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
	
	@RequestMapping("/page/user")
	public ModelAndView showUserManger(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/user_manager.jsp");
		Long page= null;
		Integer pageSize = null;
		try{
		 page  =  (Long) request.getAttribute("page");
		 pageSize = (Integer)request.getAttribute("pageSize");
		}catch(NullPointerException e){
			page = 1L;
			pageSize = 20;
		}
		if(page == null){
			page = 1L;
		}
		if(pageSize == null){
			pageSize = 20;
		}
		
		UserManager userPager = new  UserManager();
		long firstIndex = (page - 1 )*pageSize;
		userPager.setFirstIndex(firstIndex);
		userPager.setPageSize(pageSize);
		List<UserManager> userList =mUserManagerService.findPage(userPager);
		Long total = mUserManagerService.getUserTotalCount();
				
		if(total != null && pageSize != null){
			total = total % pageSize +1;
		}
		mav.addObject("total",total);
		mav.addObject("userList",userList);
		return mav;
	}

}
