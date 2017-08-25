package org.ql.shopping.controller.lottery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.HttpUrl;
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
	
	private String url(String url){
		return HttpUrl.replaceUrl("/lottery/fill/" + url);
	}
	@RequestMapping("/view/add")
	public String showAddView(Model model){
		
		model.addAttribute("addFillUrl",url("operate/add"));
		model.addAttribute("treeAllUrl",HttpUrl.replaceUrl("/lottery/clazz/operate/all"));
		return "page/lottery/lottery_fill_add.jsp";
	}
	
	@RequestMapping(value="/operate/add",method=RequestMethod.POST)
	@ResponseBody
	public Result addFillOpen(LotteryFillOpen params){
		Result result = new Result();
		
		try{
			checkAddFillOpenParams(params);
			
			//需要创建时间
			params.setLotteryFillCreaterDate(new Date());
			params.setSendStatus(C.LotteryType.SEND_STATUS_UNFINSH);
			
			mLotteryFillOpenService.addFillOpen(params);
			
			result.setCode(Code.SUCCESS);
		}catch(Exception e){
			logger.error("addFillOpen",e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}
	
	@RequestMapping("/operate/list")
	@ResponseBody
	public Rows findByParams(LotteryFillOpen params){
		Rows rows = new Rows();
		
		try{
			List<LotteryFillOpen> selectByParams = mLotteryFillOpenService.selectByParams(params);
			rows.setCode(Code.SUCCESS);
			rows.setList(selectByParams);
		}catch(Exception e ){
			logger.error("findByParams",e);
			ResultHintUtils.setSystemError(rows, e);
		}
		
		return rows;
	}

	/**
	 * 添加 彩票类型 的检测 创建的参数 是否正确
	 * @param params
	 */
	private void checkAddFillOpenParams(LotteryFillOpen params) {
		BigDecimal awardLBi = params.getAwardLBi();
		Integer createUserId = params.getCreateUserId();
		BigDecimal fillLBi = params.getFillLBi();
		BigDecimal lotteryFillUnitPrice = params.getLotteryFillUnitPrice();
		Integer lotteryTypeId = params.getLotteryTypeId();
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
		if(createUser== null){
			throw new ParamsErrorException("参数不正确");
		}
	}
	
}
