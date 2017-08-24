package org.ql.shopping.controller.lottery;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.lottery.LotteryClazzSearch;
import org.ql.shopping.pojo.result.LotteryClazzTree;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.service.lottery.ILotteryClazzService;
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
@RequestMapping("/lottery/clazz")
public class LotteryClazzController {

	private Logger logger = LoggerFactory
			.getLogger(LotteryClazzController.class);

	private String url(String url){
		return HttpUrl.replaceUrl("/lottery/clazz/"+url);
	}
	
	@Resource
	private ILotteryClazzService mLotteryClazzService;
	
	@RequestMapping("/view/add")
	public String showAddView(Model model){
		model.addAttribute("clazzUrl", url("operate/all"));
		model.addAttribute("addUrl",url("operate/add"));
		return "page/lottery/lottery_clazz_add.jsp";
	}

	@RequestMapping("/operate/add")
	@ResponseBody
	public Result addClazz(LotteryClazzSearch params) {
		
		Result result = new Result();
		
		try {
			if(params.getLotteryClazzName() == null){
				throw new LotteryException("参数不正确");
			}
			if(params.getLotteryClazzParentId() != null){
				LotteryClazz parentClazz =  mLotteryClazzService.selectByKey(params.getLotteryClazzParentId());
				if(parentClazz == null){
					throw new LotteryException("参数不正确");
				}
			}
			mLotteryClazzService.addClazz(params);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("addClazz", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	/**
	 * 添加大类参数检测
	 * 
	 * @param params
	 */
	private void checkAddClazzParams(LotteryClazzSearch params) {
		/*
		 * 必须传入 名称 如parentId == null 就修改为最外层
		 */
		if (StringUtils.isEmpty(params.getLotteryClazzName())) {
			throw new LotteryException("名称不能为空");
		}

	}

	@RequestMapping("/operate/all")
	@ResponseBody
	public Result getClazzAll() {

		Result result = new Result();
		try {
			LotteryClazzTree findClazzByParentId = mLotteryClazzService.findClazzByParentId();
			result.setData(findClazzByParentId);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("getClazzAll", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

}
