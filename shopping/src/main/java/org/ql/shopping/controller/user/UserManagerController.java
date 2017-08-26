package org.ql.shopping.controller.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.UrlResult;
import org.ql.shopping.pojo.result.MainLeftNav;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.user.IUserLoginService;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.MainNavFactroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	private IUserServiceManagerService mUserManagerService;

	@RequestMapping("/login")
	public String userManagerLogin() {
		return "login.jsp";
	}

	@RequestMapping("/toBack")
	public ModelAndView toBack(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession s = request.getSession();
		s.removeAttribute("token");
		mav.setViewName("redirect:/login.jsp");
		return mav;
	}

	@RequestMapping(value = "/toLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result userManagerLogin(HttpServletRequest request, UserManager userParams) {
		Result result = new Result();
		try {
			String account = userParams.getAccount();
			String pw = userParams.getPw();
			if (StringUtils.isEmpty(account) || StringUtils.isEmpty(pw)) {
				result.setCode(Code.ERROR);
				result.setMessage("账号或密码不能为空");
			} else {

				UserManager userLogin = mUserManagerService.findUserByAccount(account);

				if (userLogin == null || !pw.equals(userLogin.getPw())) {
					result.setCode(Code.ACCOUNT_OR_PW_ERROR);
					result.setMessage("账号或密码不正确");
				} else {
					result.setCode(Code.SUCCESS);
					UrlResult login = new UrlResult();
					login.setUrl("main.do");
					result.setData(login);
					HttpSession s = request.getSession();
					s.setAttribute("token", account);
					s.setAttribute("userId", userLogin.getId());
					s.setAttribute("power", userLogin.getPower());
				}
			}
		} catch (Exception e) {
			logger.error("userManagerLogin", e);
			result.setCode(Code.ERROR);
			result.setMessage("系统内部错误");
		}
		return result;
	}

	@RequestMapping(value = "/main")
	public ModelAndView showMainView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main.jsp");
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

}
