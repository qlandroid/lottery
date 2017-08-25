package org.ql.shopping.controller.lottery;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.service.lottery.ILotteryTypeService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lottery/type")
public class LotteryTypeController {

	private Logger logger = LoggerFactory.getLogger(LotteryTypeController.class);
	
	private String url(String url) {
		return HttpUrl.replaceUrl("/lottery/type/" + url);
	}
	
	@Resource
	private ILotteryTypeService mLotteryTypeService;
	
	@RequestMapping("/view/add")
	public String showAddView(Model model ){
		
		model.addAttribute("treeAllUrl", HttpUrl.replaceUrl("/lottery/clazz/operate/all"));
		model.addAttribute("typeAddUrl",url("operate/add"));
		return "page/lottery/lottery_type_add.jsp";
	}
	@RequestMapping("/operate/add")
	@ResponseBody
	public Result addType(LotteryTypeSearch params){
		Result result = new Result();
		
		try{
			checkAddTypeParams(params);
			
			mLotteryTypeService.addType(params);
			
			result.setCode(Code.SUCCESS);
		}catch(Exception e){
			logger.error("addType",e);
			ResultHintUtils.setSystemError(result,e);
		}
		
		return result;
	}

	private void checkAddTypeParams(LotteryTypeSearch params) {
		//彩票规则
		String rule =params.getLotteryRule();
		//彩票的名称
		String name = params.getLotteryName();
		//彩票描述
		String remark = params.getLotteryRemark();
		
		if(StringUtils.isEmpty(rule)
				||StringUtils.isEmpty(name)
				||StringUtils.isEmpty(remark)){
			throw new ParamsErrorException("参数不正确");
		}
		
	}
	
	
	
	
}
