package client.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.pojo.fill.FillOpenSearch;
import client.pojo.lottery.ClientLotteryFillOpenSearch;
import client.service.lottery.IClientFillOpenService;

@Controller
@RequestMapping("/a/fill")
public class ClientFillOpenController {

	private Logger logger = LoggerFactory
			.getLogger(ClientFillOpenController.class);

	@Resource
	private IClientFillOpenService mClientFillOpenService;

	
	@RequestMapping("/list")
	@ResponseBody
	public Rows getList(ClientLotteryFillOpenSearch params) {
		Rows rows = new Rows();
		try {

			checkGetListParams(params);
			
			List<ClientLotteryFillOpenSearch> fillOpenList = mClientFillOpenService.selectFillOpenList(params);
			long total = mClientFillOpenService.getFillOpenList(params);
			rows.setCode(Code.SUCCESS);
			rows.setList(fillOpenList);
			rows.setTotal(total);
		} catch (Exception e) {
			logger.error("getList", e);
			ResultHintUtils.setSystemError(rows, e);
		}
		return rows;
	}

	private void checkGetListParams(ClientLotteryFillOpenSearch params) {
		params.getLotteryClzzId();
		params.getLotteryTypeId();
	}

	@RequestMapping("/details")
	@ResponseBody
	public Result getDeatilsById(FillOpenSearch params) {
		Result result = new Result();
		try {
			checkDetailsByidParams(params);
			// 通过id获取当前彩票信息
			Integer fillOpenId = params.getLotteryFillOpenId();
			FillOpenSearch details = mClientFillOpenService
					.selectDetailsByOpenId(fillOpenId);
			result.setCode(Code.SUCCESS);
			result.setData(details);
		} catch (Exception e) {
			logger.error("getDeatilsById", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	private void checkDetailsByidParams(FillOpenSearch params) {
		
	}

}
