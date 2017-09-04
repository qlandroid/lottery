package org.ql.shopping.controller.manifest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.ql.shopping.pojo.manifest.ManifestLBiChangeSearch;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.service.manifest.ILBiManifestManagerService;
import org.ql.shopping.util.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lbichange")
public class LBiChangeManifestController {
	private Logger logger = LoggerFactory.getLogger(LBiChangeManifestController.class);

	@Resource
	private ILBiManifestManagerService mLBiManifestMangerService;

	private String url(String url) {
		return HttpUrl.replaceUrl("/lbichange" + url);
	}

	@RequestMapping("/view/list")
	public String showList(Model model, ManifestLBiChange params) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("changeListUrl", url("/operate/list"));
			map.put("params", params);
		} catch (Exception e) {
			logger.error("showList", e);
		}
		model.addAllAttributes(map);

		return "page/manifest/l_bi_change_manifest.jsp";
	}

	@RequestMapping("/operate/list")
	@ResponseBody
	public TabelResult getList(ManifestLBiChangeSearch params) {
		TabelResult result = new TabelResult();

		try {
			checkListParams(params);
			List<ManifestLBiChangeSearch> data = mLBiManifestMangerService.selectListPageByParams(params);

			Integer count = mLBiManifestMangerService.getListCountByParams(params);

			result.setCount(new Long(count));
			result.setData(data);
			result.setCode(0);
		} catch (Exception e) {
			logger.error("getList", e);
			result.setMsg("就不告诉你错哪了");
			result.setCode(100);
		}

		return result;
	}

	private void checkListParams(ManifestLBiChange params) {
		// TODO Auto-generated method stub

	}
}
