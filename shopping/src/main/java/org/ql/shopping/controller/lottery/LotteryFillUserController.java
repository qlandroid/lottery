package org.ql.shopping.controller.lottery;

import org.ql.shopping.pojo.lottery.LotteryFillUserSearch;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/fill")
public class LotteryFillUserController {

	private Logger logger = LoggerFactory.getLogger(LotteryFillUserController.class);
	
	@RequestMapping("/operate/buy")
	public Result buyFillLottery(LotteryFillUserSearch params){
		Result result = new Result();
		
		try{
			checkBuyFillLotteryParams(params);
			
			
		}catch(Exception e){
			logger.error("buyFillLottery",e);
			ResultHintUtils.setSystemError(result,e);
		}
		
		
		return result ;
		
	}

	private void checkBuyFillLotteryParams(LotteryFillUserSearch params) {
		// TODO Auto-generated method stub
		
	}
}
