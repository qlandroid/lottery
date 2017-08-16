package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.dao.ILotterySSQDao;
import org.ql.shopping.pojo.LotterySSQ;
import org.ql.shopping.pojo.Rows;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.service.ILotteryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lottery")
public class LotterySSQController {

	@Resource
	private ILotteryService mLotterySSQService;

	@RequestMapping("/findAll.do")
	@ResponseBody
	public Rows findALl(ListParams params) {
		Rows rows = new Rows();
		rows.setCode(Code.SUCCESS);
		List<LotterySSQ> list = mLotterySSQService.findAll(params);
		rows.setList(list);
		int totalCount = mLotterySSQService.queryTotalCount(params);
		totalCount = totalCount % params.getPageSize() + 1;
		rows.setTotal(totalCount);
		return rows;
	}

}
