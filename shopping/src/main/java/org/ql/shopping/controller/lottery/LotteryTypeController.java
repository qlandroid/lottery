package org.ql.shopping.controller.lottery;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.ql.shopping.pojo.lottery.StaticLotteryType;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.service.lottery.ILotteryTypeService;
import org.ql.shopping.service.lottery.IStaticLotteryTypeService;
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
	@Resource
	private IStaticLotteryTypeService mStaticLotteryTypeService;

	@RequestMapping("/view/add")
	public String showAddView(Model model) {

		model.addAttribute("treeAllUrl", HttpUrl.replaceUrl("/lottery/clazz/operate/all"));
		model.addAttribute("typeAddUrl", url("operate/add"));
		model.addAttribute("lotteryTypeUrl", url("operate/getLotteryTypeList"));
		return "page/lottery/lottery_type_add.jsp";
	}

	@RequestMapping("/operate/add")
	@ResponseBody
	public Result addType(LotteryTypeSearch params) {
		Result result = new Result();

		try {
			checkAddTypeParams(params);

			mLotteryTypeService.addType(params);

			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("addType", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	@RequestMapping("operate/getLotteryTypeList")
	@ResponseBody
	public Rows getLotteryTypeList() {
		Rows rows = new Rows();
		try {
			List<StaticLotteryType> typeAll = mStaticLotteryTypeService.getTypeAll();
			rows.setList(typeAll);
			rows.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("getLotteryTypeList", e);
			ResultHintUtils.setSystemError(rows, e);
		}
		return rows;
	}

	private void checkAddTypeParams(LotteryTypeSearch params) {
		// 彩票规则
		String rule = params.getLotteryRule();
		// 彩票的名称
		String name = params.getLotteryName();
		// 彩票描述
		String remark = params.getLotteryRemark();
		// 彩票类型
		String lotteryType = params.getLotteryType();

		if (StringUtils.isEmpty(rule) || StringUtils.isEmpty(name) || StringUtils.isEmpty(remark)
				|| StringUtils.isEmpty(lotteryType)) {
			throw new ParamsErrorException("参数不正确");
		}
		List<StaticLotteryType> type = mStaticLotteryTypeService.selectByType(lotteryType);

		if (type == null || type.size() <= 0) {
			throw new ParamsErrorException("参数不正确");
		}

	}

}
