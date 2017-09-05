package org.ql.shopping.service.manifest.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestBuyMapper;
import org.ql.shopping.pojo.manifest.ManifestBuy;
import org.ql.shopping.service.manifest.IManifestBuyService;
import org.springframework.stereotype.Service;

@Service("anfiestBuyService")
public class ManifestBuyServiceImpl implements IManifestBuyService {

	@Resource
	private ManifestBuyMapper mManifestBuyMapper;
	
	public int addManifest(ManifestBuy params) {
		return mManifestBuyMapper.insert(params);
	}

}
