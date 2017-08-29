package client.controller;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.dao.lottery.LotteryFillOpenMapper;
import org.ql.shopping.dao.lottery.LotteryFillUserMapper;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.service.lottery.impl.LotteryFillOpenService;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.pojo.fill.FillOpenSearch;
import client.service.lottery.IClientFillOpenService;
import client.service.lottery.impl.ClientFillOpenService;

@Controller
@RequestMapping("/a/fill")
public class ClientFillOpenController {
	
	private Logger logger = LoggerFactory.getLogger(ClientFillOpenController.class);
	
	@Resource
	private IClientFillOpenService mClientFillOpenService;
	
	@RequestMapping("/details")
	@ResponseBody
	public Result getDeatilsById(FillOpenSearch params ){
		Result result = new Result();
		try{
			checkDetailsByidParams(params);
			//通过id获取当前彩票信息
			Integer fillOpenId = params.getLotteryFillOpenId();
			FillOpenSearch details = mClientFillOpenService.selectDetailsByOpenId(fillOpenId);
			result.setCode(Code.SUCCESS);
			result.setData(details);
			
		}catch(Exception e){
			logger.error("getDeatilsById",e);
			ResultHintUtils.setSystemError(result,e);
		}
		return result ;
	}


	private void checkDetailsByidParams(FillOpenSearch params) {
		
	}
}
