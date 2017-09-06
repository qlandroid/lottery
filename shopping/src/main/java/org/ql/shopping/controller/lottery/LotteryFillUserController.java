package org.ql.shopping.controller.lottery;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.lottery.FillUserDetails;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/fill")
public class LotteryFillUserController {

	private Logger logger = LoggerFactory.getLogger(LotteryFillUserController.class);
	
	@Resource
	private ILotteryFillUserService mLotteryFillUserService;
	
	
	@RequestMapping("/operate/list")
	@ResponseBody
	public TabelResult getOverBuyFillUserByOpenId(FillUserDetails params){
		TabelResult rows = new TabelResult();
		
		try{
			List<FillUserDetails> userList = mLotteryFillUserService.selectUserDetailsByOpenId(params.getLotteryFillOpenId());
			rows.setData(userList);
			rows.setCount(new Long(userList.size()));
			rows.setCode(0);
		}catch(Exception e){
			logger.error("getOverBuyFillUserByOpenId",e);
			ResultHintUtils.setSystemError(rows, e);
		}
		return rows;
	}
	
	

	
	
}
