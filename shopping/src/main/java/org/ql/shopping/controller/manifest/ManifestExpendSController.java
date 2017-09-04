package org.ql.shopping.controller.manifest;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.pojo.manifest.ManifestExpendSs;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.service.manifest.IManifestExpendSService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.ResultHintUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/manifest/expend")
@Controller
public class ManifestExpendSController {

	private Logger logger = LoggerFactory.getLogger(ManifestExpendSController.class);
	
	private String url(String url){
		return HttpUrl.replaceUrl("/manifest/expend" + url);
	}
	
	@Resource
	private IManifestExpendSService mManifestExpendSService;
	
	
	@RequestMapping("/view/list")
	public String showListView(Model model){
		model.addAttribute("expendList",url("/operate/list"));
		return "page/manifest/expend_manager.jsp";
	}
	
	@RequestMapping("/operate/list")
	@ResponseBody
	public TabelResult getList(ManifestExpendSs params){
		TabelResult row = new TabelResult();
		
		try{
			List<ManifestExpendSs> selectListByParams = mManifestExpendSService.selectListByParams(params);
			Integer count = mManifestExpendSService.getListCountByParams(params);
			row.setCode(0);
			row.setCount(new Long(count));
			row.setData(selectListByParams);
		}catch(Exception e){
			logger.error("getList",e);
			ResultHintUtils.setSystemError(row, e);
		}
		
		
		return row;
		
	}
	
}
