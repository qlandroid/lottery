package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.ql.shopping.HttpUrl;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.AccountErrorException;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.result.UrlResult;
import org.ql.shopping.service.IUserClientManagerService;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userClient")
public class UserClientMangerController {
	private Logger logger = LoggerFactory.getLogger(UserClientMangerController.class);

	@Resource
	private IUserClientManagerService mUserClientManagerService;

	private String url(String url) {
		return HttpUrl.replaceUrl("/userClient" + url);
	}

	@RequestMapping("/view/add")
	public ModelAndView showAddView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/user_client_add.jsp");
		mav.addObject("addUrl", url("/operate/addUser"));
		mav.addObject("addOperateUrl",url("/operate/add"));
		return mav;
	}

	@RequestMapping("/view/change")
	public String showChangeView(UserClientManagerParams params, Model model) {
		UserClient queryUser = mUserClientManagerService.findUserById(params.getId());
		model.addAttribute("user", queryUser);
		model.addAttribute("changeUrl", url("/operate/change"));
		return "/page/user_client_change.jsp";
	}

	@RequestMapping("/view/search")
	public String showSearchView(Model model) {
		try {
			model.addAttribute("searchUrl", url("/list"));
			return "/page/user_client_search.jsp";
		} catch (Exception e) {
			logger.error("showChangeView", e);
		}
		return "error/page/iframe_error.jsp";
	}

	/**
	 * 通过条件进行分页查询所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView getUserList(UserClientManagerParams params) {
		ModelAndView mav = new ModelAndView();
		try {
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

			List<UserClient> list = mUserClientManagerService.findUser(params);
			Long total = mUserClientManagerService.getTotalCount(params);
			Long pageTotal = total / params.getPageSize() + 1;
			mav.addObject("pageTotal", pageTotal);
			mav.addObject("total", total);

			mav.addObject("addUrl", url("/"));
			mav.addObject("page", params.getPage());
			mav.addObject("userList", list);
			mav.addObject("params", params);

			mav.addObject("url", url("/list"));
			mav.addObject("searchViewUrl", url("/view/search"));
			mav.addObject("addViewUrl", url("/view/add"));
			mav.addObject("incomeViewUrl", url("/view/income"));
			mav.addObject("changeViewUrl", url("/view/change"));
			mav.addObject("deleteViewUrl", url("/operate/delete"));

			mav.setViewName("page/user_client_manager.jsp");
		} catch (Exception e) {
			logger.error("getUserList", e);
		}

		return mav;
	}

	@RequestMapping(value = "/operate/add", method = RequestMethod.POST)
	@ResponseBody
	public Result addUser(HttpServletRequest request, UserClientManagerParams params) {
		Result result = new Result();
		try {
			String account = params.getAccount();
			String pw = params.getPw();
			if (StringUtils.isEmpty(account)) {
				throw new AccountErrorException("账号不能为空");
			}
			if (StringUtils.isEmpty(pw)) {
				throw new AccountErrorException("密码不能为空");
			}
			account = new String(account.getBytes(),"gbk");
			UserClient u = mUserClientManagerService.findUserByAccount(params.getAccount());
			if(u != null){
				throw new LotteryException("账号已存在，请重新填写");
			}
			mUserClientManagerService.inserte(params);
			UrlResult url = new UrlResult();
			url.setUrl(url("/list"));
			result.setCode(Code.SUCCESS);
			result.setData(url);

		} catch (Exception e) {
			logger.error("addUser", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	@RequestMapping(value = "/operate/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteUser(HttpServletRequest request, UserClientManagerParams params) {
		Result result = new Result();
		try {
			Long id = params.getId();
			if (id == null) {
				throw new LotteryException("参数不正确");
			}
			mUserClientManagerService.deleteUser(params);
			result.setCode(Code.SUCCESS);

		} catch (Exception e) {
			logger.error("addUser", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	@RequestMapping(value = "/operate/update", method = RequestMethod.POST)
	@ResponseBody
	public Result updateUser(HttpServletRequest request, UserClientManagerParams params) {
		Result result = new Result();
		try {
			Long id = params.getId();
			if (id == null) {
				throw new LotteryException("参数不正确");
			}
			mUserClientManagerService.updateUser(params);
			result.setCode(Code.SUCCESS);

		} catch (Exception e) {
			logger.error("addUser", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

}
