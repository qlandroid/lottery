package org.ql.shopping.controller.manifest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.manifest.LBiChangeManager;
import org.ql.shopping.pojo.result.Result;
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
	public String showList(Model model, LBiChangeManager params) {

		Map<String, Object> map = new HashMap<String, Object>();
		Long page = params.getPage();
		Integer pageSize = params.getPageSize();
		if (page == null) {
			params.setPage(1l);
		}
		if (pageSize == null) {
			params.setPageSize(10);
		}
		try {
			map.put("listUrl", url("/operate/list"));
			map.put("params", params);
		} catch (Exception e) {
			logger.error("showList", e);
		}
		model.addAllAttributes(map);

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
		if (params.getPage() == null) {
			params.setPage(1l);
		}

		params.setPageSize(pageSize);
		try {
			checkListParams(params);
			List<LBiChangeManager> data = mLBiManifestMangerService.findAnd(params);

			Long count = mLBiManifestMangerService.getTotalCountAnd(params);

			result.setCount(count);
			result.setData(data);
			result.setCode(Code.SUCCESS);
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
