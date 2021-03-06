package org.ql.shopping.controller.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.code.UrlFactory;
import org.ql.shopping.exception.AccountErrorException;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.manifest.IncomeManifest;
import org.ql.shopping.pojo.params.RechagerHanderLBiParams;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.UrlResult;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.pojo.user.UserClientSSearch;
import org.ql.shopping.service.manifest.ILBiManifestManagerService;
import org.ql.shopping.service.manifest.IManifestIncomeManagerService;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.util.HttpUrl;
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
	@Resource
	private IManifestIncomeManagerService mIncomeManifestManagerService;
	@Resource
	private ILBiManifestManagerService mLBiManifestMangaerService;

	private String url(String url) {
		return HttpUrl.replaceUrl("/userClient" + url);
	}

	@RequestMapping("/view/login")
	public ModelAndView showLoginView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("client/main.jsp");
		mav.addObject("addUrl", url("/operate/addUser"));
		mav.addObject("addOperateUrl", url("/operate/add"));
		return mav;
	}
	
	@RequestMapping("/view/add")
	public ModelAndView showAddView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/user_client_add.jsp");
		mav.addObject("addUrl", url("/operate/addUser"));
		mav.addObject("addOperateUrl", url("/operate/add"));
		return mav;
	}

	@RequestMapping("/view/change")
	public String showChangeView(UserClientSSearch params, Model model) {
		UserClient queryUser = mUserClientManagerService.findUserByUserId(params.getId());
		model.addAttribute("user", queryUser);
		model.addAttribute("changeUrl", url("/operate/update"));
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
	 * 充值 页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/recharge")
	public String showRechargeView(Model model, UserClientSSearch params) {

		try {
			UserClient userClient = mUserClientManagerService.findUserByUserId(params.getId());
			model.addAttribute("user", userClient);
			model.addAttribute("submitUrl", url("/operate/rechager"));

		} catch (Exception e) {
			logger.error("showRechargeView", e);
			return UrlFactory.iframeError;
		}

		return "page/recharge.jsp";
	}

	/**
	 * 通过条件进行分页查询所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView getUserList(UserClientSSearch params) {
		ModelAndView mav = new ModelAndView();
		try {
			List<UserClientSSearch> list = mUserClientManagerService.findUser(params);
			Integer total = mUserClientManagerService.getListCountByParams(params);
			Integer pageTotal = total / params.getPageSize() + 1;
			mav.addObject("pageTotal", pageTotal);
			mav.addObject("total", total);

			mav.addObject("addUrl", url("/"));
			mav.addObject("page", params.getPage());
			mav.addObject("userList", list);
			mav.addObject("params", params);

			mav.addObject("url", url("/list"));
			mav.addObject("searchViewUrl", url("/view/search"));
			mav.addObject("addViewUrl", url("/view/add"));
			mav.addObject("incomeViewUrl", url("/view/recharge"));
			mav.addObject("changeViewUrl", url("/view/change"));
			mav.addObject("deleteViewUrl", url("/operate/delete"));

			mav.setViewName("page/user_client_manager.jsp");
		} catch (Exception e) {
			logger.error("getUserList", e);
		}

		return mav;
	}
	
	@RequestMapping(value = "/operate/login" ,method = RequestMethod.POST)
	@ResponseBody
	public Result loginUser(UserClientManagerParams params){
		Result result = new Result();
		try{
			checkLoginParams(params);
			result.setCode(Code.SUCCESS);
		}catch(Exception e){
			logger.error("loginUser",e);
			ResultHintUtils.setSystemError(result,e);
		}
		return result ;
	}

	private void checkLoginParams(UserClientManagerParams params) {
		String account = params.getAccount();
		String pw = params.getPw();
		if(StringUtils.isEmpty(account)|| StringUtils.isEmpty(pw)){
			throw new ParamsErrorException("登陆失败");
		}
		UserClient findUserByAccount = mUserClientManagerService.findUserByAccount(account);
		if(findUserByAccount == null){
			throw new ParamsErrorException("账号或密码不正确");
		}
		
		if(!pw.equals(params.getPw())){
			throw new ParamsErrorException("账号或密码不正确");
		}
	}

	@RequestMapping(value = "/operate/add", method = RequestMethod.POST)
	@ResponseBody
	public Result addUser(HttpServletRequest request, UserClientSSearch params) {
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
			UserClient u = mUserClientManagerService.findUserByAccount(params.getAccount());
			if (u != null) {
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
	public Result deleteUser(HttpServletRequest request, UserClientSSearch params) {
		Result result = new Result();
		try {
			Integer id = params.getUserId();
			if (id == null) {
				throw new LotteryException("参数不正确");
			}
			mUserClientManagerService.deleteUser(params);
			result.setCode(Code.SUCCESS);

		} catch (Exception e) {
			logger.error("deleteUser", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	@RequestMapping(value = "/operate/update", method = RequestMethod.POST)
	@ResponseBody
	public Result updateUser(HttpServletRequest request, UserClient params) {
		Result result = new Result();
		try {
			Integer id = params.getUserId();
			if (id == null) {
				throw new LotteryException("参数不正确");
			}
			mUserClientManagerService.updateUser(params);
			result.setCode(Code.SUCCESS);

		} catch (Exception e) {
			logger.error("updateUser", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	@RequestMapping(value = "/operate/rechager", method = RequestMethod.POST)
	@ResponseBody
	public Result rechagerLBi(HttpServletRequest request, RechagerHanderLBiParams params) {
		Result result = new Result();
		try {
			checkRechagerParams(params);
			
			UserClientSSearch findUserById = mUserClientManagerService.findUserByUserId(params.getUserId());
			if(findUserById == null){
				throw new LotteryException("充值用户不存在，请检查");
			}
			// 先生成订单
			IncomeManifest createManifest = new IncomeManifest();
			createManifest.setUserId(params.getUserId());
			createManifest.setPayMoney(params.getPayMoney());
			createManifest.setInQty(params.getInQty());
			createManifest.setZhifubaoDoc(params.getZhifubaoDoc());
			mIncomeManifestManagerService.createIncomeManifest(createManifest);
			// 完成订单
			mIncomeManifestManagerService.incomeSuccessById(createManifest.getIncomeId(), params.getRemark(),
					C.CHANGE_OPERATE_TYPE_OTHER);
			
			result.setCode(Code.SUCCESS);

		} catch (Exception e) {
			logger.error("rechagerLBi", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	private void checkRechagerParams(RechagerHanderLBiParams params) {
		Integer id = params.getUserId();
		Double payMoney = params.getPayMoney();
		Double inQty = params.getInQty();
		String mark = params.getRemark();
		if (id == null || isEmpte(payMoney) || isEmpte(inQty) || StringUtils.isEmpty(mark)) {
			throw new ParamsErrorException("参数不正确");
		}
	}

	private boolean isEmpte(Double qty) {
		if (qty == null || qty <= 0) {
			return true;
		}
		return false;
	}
}
