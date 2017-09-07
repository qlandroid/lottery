package client.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.service.lottery.IClientLotteryTypeService;

@Controller
@RequestMapping("/lottery/type")
public class ClientLotteryTypeController {

	private Logger  logger = LoggerFactory.getLogger(ClientLotteryTypeController.class);
	
	@Resource
	private IClientLotteryTypeService mLotteryTypeService;
	
	@RequestMapping("/all")
	@ResponseBody
	public Rows getAllType(){
		Rows rows = new Rows();
		try {
			List<LotteryTypeSearch> list = mLotteryTypeService.selectAll();
			Integer count = mLotteryTypeService.getAllCount();
			rows.setCode(Code.SUCCESS);
			rows.setList(list);
			rows.setTotal(count);
		} catch (Exception e) {
			logger.error("getAllType", e);
			ResultHintUtils.setSystemError(rows, e);
		}
		return rows;
	}
}
