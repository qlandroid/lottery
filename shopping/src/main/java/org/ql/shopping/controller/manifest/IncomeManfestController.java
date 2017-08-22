package org.ql.shopping.controller.manifest;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.manifest.IncomeManifest;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.service.manifest.IManifestIncomeManagerService;
import org.ql.shopping.util.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/income")
public class IncomeManfestController {
	private Logger logger = LoggerFactory.getLogger(IncomeManfestController.class);
	
	@Resource
	private IManifestIncomeManagerService mIncomeManifestManagerService;

	
	private String url(String url){
		return HttpUrl.replaceUrl("/income"+url);
	}
	@RequestMapping("/view/search")
	public String showSearchView(Model model,IncomeManifest params){
		return "page/search/manifest_income_search.jsp";
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
			model.addAttribute("listUrl", url("/operate/list"));
			model.addAttribute("serachViewUrl",url("/view/search"));
			model.addAttribute("params",params);
			
		}catch(Exception e){
			logger.error("showMainView",e);
		}
		return "page/manifest/income_manager.jsp";
	}
	@RequestMapping(value="/operate/list",method=RequestMethod.POST)
	@ResponseBody
	public TabelResult operateList(Model model,IncomeManifest params){
		TabelResult result = new TabelResult();
		
		try{ 
			
			Long page = params.getPage();
			Integer pageSize = params.getPageSize();
			if(page == null){
				params.setPage(1l);
			}
			if(pageSize == null )
				params.setPageSize(10);
			
			List<IncomeManifest> list = mIncomeManifestManagerService.findPageAnd(params);
			
			Long count = mIncomeManifestManagerService.getToatalCount(params);
			result.setCode(Code.SUCCESS);
			result.setData(list);
			result.setCount(count);
			
		}catch(Exception e){
			logger.error("showMainView",e);
			result.setCode(Code.ERROR);
			result.setMsg("出错了");
		}
		return result;
	}
}
