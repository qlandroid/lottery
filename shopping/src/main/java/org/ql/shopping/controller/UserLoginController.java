package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.AccountNotFindException;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.PasswordErrorException;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.Rows;
import org.ql.shopping.pojo.UserLogin;
import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.service.IUserClientService;
import org.ql.shopping.service.IUserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@Resource
	IUserLoginService mUserService;
	@Resource
	IUserClientService mUserClientService;

	@RequestMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest request, UserLogin user, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			checkLoginParams(user);

			List<UserLogin> queryUser = mUserService.queryUserOfAccount(user.getAccount());
			if (queryUser == null || queryUser.size() == 0) {
				throw new AccountNotFindException("账号不存在");
			}
			queryUser = mUserService.queryUser(user);
			if (queryUser == null || queryUser.size() == 0) {
				throw new PasswordErrorException("密码不正确");
			}
			UserLogin queryU = queryUser.get(0);
			HttpSession session = request.getSession();
			session.setAttribute("token", queryU.getAccount());
			modelAndView.setViewName("redirect:/user/main.do");

		} catch (AccountNotFindException e) {
			logger.error("toLogin", e);
			modelAndView.addObject("errorMsg", e.getMessage());
			modelAndView.setViewName("login.jsp");
		} catch (LotteryException e1) {
			logger.error("toLogin", e1);
			modelAndView.addObject("errorMsg", e1.getMessage());
			modelAndView.setViewName("login.jsp");
		} catch (Exception e) {
			logger.error("toLogin", e);
			modelAndView.addObject("errorMsg", "系统内部错误");
			modelAndView.setViewName("login.jsp");
		}

		return modelAndView;
	}
	
	@RequestMapping("/main")
	public String mainView(HttpServletRequest request,ModelAndView modeAndView){
		String account = (String) request.getSession().getAttribute("token");
		if(StringUtils.isEmpty(account)){
			modeAndView.setViewName("redirect:/user/login.do");
		}
		return "main.jsp";
	}

	@RequestMapping("/login")
	public String loginView() {
		return "login.jsp";
	}

	private void checkLoginParams(UserLogin user) throws LotteryException {
		if (user == null || StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPw())) {
			throw new LotteryException("参数不正确");
		}
	}

	@RequestMapping("/page/addUser")
	public String addUserHtml() {
		return "page/add_user.html";
	}

	

	@RequestMapping("/register.do")
	@ResponseBody
	public Result registerUser(UserLogin regUser) {
		Result result = new Result();
		try {
			checkRegisterUser(regUser);

			List<UserLogin> list = mUserService.queryUserOfAccount(regUser.getAccount());
			if (list != null && list.size() > 0) {
				result.setCode(Code.ACCOUNT_HAVE);
				result.setMessage("账号已经存在");
				return result;
			}
			// 添加用户
			String account = regUser.getAccount();
			mUserService.inserteUser(regUser);
			// 查询当前用户；
			List<UserLogin> userList = mUserService.queryUserOfAccount(account);
			UserLogin u = userList.get(0);
			// 创建当前用户个人详情，并设置当前账号的唯一账号ID；
			UserClient client = new UserClient();
			client.setUserId(u.getId());
			mUserClientService.addUserClient(client);

			result.setCode(Code.SUCCESS);

		} catch (LotteryException le) {
			result.setCode(Code.ERROR);
			String msg = le.getMessage();
			result.setMessage(msg);
		} catch (Exception e) {
			result.setCode(Code.ERROR);
			result.setMessage("系统内部错误");
		}
		return result;
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public Result deleteAllUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		Result res = new Result();
		if(session == null || session.getAttribute("token") == null){
			res.setCode(Code.ERROR);
			res.setMessage("账号没有登陆");
		}else{
			mUserService.deleteAllUser();
			res.setCode(Code.SUCCESS);
		}
		
		return res;
	}

	private void checkRegisterUser(UserLogin regUser) throws LotteryException {
		if (regUser == null) {
			throw new LotteryException("参数不正确");
		}
		String account = regUser.getAccount();
		if (StringUtils.isEmpty(account) || StringUtils.isEmpty(regUser.getPw())) {
			throw new LotteryException("参数不正确");
		}

	}
}
