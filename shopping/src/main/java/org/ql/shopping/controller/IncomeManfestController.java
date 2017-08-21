package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.HttpUrl;
import org.ql.shopping.pojo.IncomeManifest;
import org.ql.shopping.service.IIncomeManifestManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/income")
public class IncomeManfestController {
	private Logger logger = LoggerFactory.getLogger(IncomeManfestController.class);
	
	@Resource
	private IIncomeManifestManagerService mIncomeManifestManagerService;
	
	private String url(String url){
		return HttpUrl.replaceUrl("/income/"+url);
	}
	
	@RequestMapping("/view/list")
	public String showMainView(Model model,IncomeManifest params){
		try{   
			List<IncomeManifest> list = mIncomeManifestManagerService.findPageAnd(params);
			Long totalCount = mIncomeManifestManagerService.getToatalCount(params);
			Long pageTotal = totalCount / params.getPageSize() + 1;
			//获得总充值积分
			Double inQty = mIncomeManifestManagerService.getTotalIncomeInQty(null);
			params.setTotalIncomeInQty(inQty);
			//获得总支付金额
			Double payMoney = mIncomeManifestManagerService.getTotalPayMoney(null);
			params.setTotalPayMoney(payMoney);
			//获得筛选后的总金额
			Double selectPayMoney = mIncomeManifestManagerService.getTotalPayMoney(params);
			params.setTotalSelectPayMoney(selectPayMoney);
			//获得筛选后总支付金额
			Double selectInQty = mIncomeManifestManagerService.getTotalPayMoney(params);
			params.setTotalSelectInQty(selectInQty);
			
			
			params.setTotal(totalCount);
			params.setPageTotal(pageTotal);
			model.addAttribute("url", url("/view/list"));
			model.addAttribute("dcoList",list);
			model.addAttribute("params",params);
			
		}catch(Exception e){
			logger.error("showMainView",e);
		}
		return "page/manifest/income_manager.jsp";
	}
}
