package org.ql.shopping.controller.lottery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.LotteryStageUtils;
import org.ql.shopping.util.MakeManifest;
import org.ql.shopping.util.MakeManifestNo;
import org.ql.shopping.util.NumberUtils;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lottery/fill")
public class LotteryFillOpenController {
	private Logger logger = LoggerFactory.getLogger(LotteryFillOpenController.class);

	@Resource
	private ILotteryFillOpenService mLotteryFillOpenService;
	@Resource
	private IUserServiceManagerService mUserServiceManagerService;
	@Resource 
	private ILotteryFillUserService mLotteryFillUserService;

	private String url(String url) {
		return HttpUrl.replaceUrl("/lottery/fill/" + url);
	}
	
	@RequestMapping("/view/list")
	public String showListView(Model model){
		model.addAttribute("fillOpenList",url("/operate/list"));
		return "page/lottery/fill/lottery_open.jsp";
	}

	@RequestMapping("/view/add")
	public String showAddView(Model model) {
		model.addAttribute("addFillUrl", url("operate/add"));
		model.addAttribute("treeAllUrl", HttpUrl.replaceUrl("/lottery/clazz/operate/all"));
		return "page/lottery/fill/lottery_fill_add.jsp";
	}

	@RequestMapping(value = "/operate/add", method = RequestMethod.POST)
	@ResponseBody
	public Result addFillOpen(HttpServletRequest request,LotteryFillOpen params) {
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		params.setCreateUserId(userId);
		try {
			checkAddFillOpenParams(params);
				
			// 需要创建时间
			params.setLotteryFillCreaterDate(new Date());
			params.setSendStatus(C.LotteryType.SEND_STATUS_UNFINSH);
			
			mLotteryFillOpenService.addFillOpen(params);
			String stage = LotteryStageUtils.createStage(C.LotteryStageFlag.FILL, params.getLotteryFillOpenId());
			params.setLotteryStage(stage);
			mLotteryFillOpenService.updateFillOpenById(params);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("addFillOpen", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	/**
	 * 添加 彩票类型 的检测 创建的参数 是否正确
	 * 
	 * @param params
	 */
	private void checkAddFillOpenParams(LotteryFillOpen params) {
		BigDecimal awardLBi = params.getAwardLBi();
		Integer createUserId = params.getCreateUserId();
		BigDecimal fillLBi = params.getFillLBi();
		BigDecimal lotteryFillUnitPrice = params.getLotteryFillUnitPrice();
		Integer lotteryTypeId = params.getLotteryTypeId();
		String name = params.getLotteryFillName();
		if(StringUtils.isEmpty(name)){
			throw new ParamsErrorException("参数不正确");
		}
		
		if (NumberUtils.isZero(awardLBi)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(createUserId)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(fillLBi)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(lotteryFillUnitPrice)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(lotteryTypeId)) {
			throw new ParamsErrorException("参数数值不正确");
		}

		UserManager createUser = mUserServiceManagerService.findUserById(createUserId);
		if (createUser == null) {
			throw new ParamsErrorException("参数不正确");
		}
	}
	
	
	@RequestMapping("/operate/list")
	@ResponseBody
	public TabelResult getList(LotteryFillOpenSearch params){
		TabelResult result = new TabelResult();
		try{
			if(params.getLimit() != null){
				params.setPageSize(params.getLimit());
			}
			List<LotteryFillOpenSearch> list = mLotteryFillOpenService.selectSearchByParams(params);
			int count = mLotteryFillOpenService.getSearchCountParams(params);
			result.setCount(new Long(count));
			result.setData(list);
			result.setCode(0);
		}catch(Exception e){
			logger.error("getList",e);
			ResultHintUtils.setSystemError(result,e);
		}
		
		return result;
	}

}
