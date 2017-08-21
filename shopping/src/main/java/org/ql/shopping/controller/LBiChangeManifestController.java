package org.ql.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.HttpUrl;
import org.ql.shopping.code.C;
import org.ql.shopping.pojo.LBiChangeManager;
import org.ql.shopping.pojo.Result;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.service.ILBiManifestManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lbichange")
public class LBiChangeManifestController {
	private Logger logger = LoggerFactory
			.getLogger(LBiChangeManifestController.class);

	@Resource 
	private ILBiManifestManagerService mLBiManifestMangerService;
	
	private String url(String url) {
		return HttpUrl.replaceUrl("/lbichange" + url);
	}

	@RequestMapping("/view/list")
	public String showList(Model model) {

		model.addAttribute("listUrl", url("/operate/list"));

		return "page/manifest/l_bi_change_manifest.jsp";
	}

	/**
	 * 数据显示信息 { code: 0, //状态码，0代表成功，其它失败 msg: "", //状态信息，一般可为空 count: 1000,
	 * //数据总量 data: [] //数据，字段是任意的。如：[{"id":1,"username":"贤心"},
	 * {"id":2,"username":"佟丽娅"}] }
	 * 
	 * @type {{url: string, where: {}, method: string, cols: [*]}}
	 */
	@RequestMapping("/operate/list")
	@ResponseBody
	public TabelResult getList(LBiChangeManager params) {
		TabelResult result = new TabelResult();
		
		Integer limit = params.getLimit();
		Integer pageSize = params.getPageSize();
		if (limit != null) {
			pageSize = limit;
		}
		if (pageSize == null) {
			pageSize = C.PAGE_SIZE;
		}
		
		params.setPageSize(pageSize);
		try {
			checkListParams(params);
			List<LBiChangeManager> data = mLBiManifestMangerService.findAnd(params);
			
			Long count = mLBiManifestMangerService.getTotalCountAnd(params);
			
			result.setCount(count);
			result.setData(data);
			result.setCode(1);
		} catch (Exception e) {
			logger.error("getList", e);
			result.setMsg("就不告诉你错哪了");
			result.setCode(100);
		}

		return result;
	}

	private void checkListParams(LBiChangeManager params) {
		// TODO Auto-generated method stub
		
	}
}
