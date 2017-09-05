package client.service.manifest.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestBuyMapper;
import org.ql.shopping.pojo.manifest.ManifestBuy;
import org.springframework.stereotype.Service;

import client.service.manifest.IClientManifestBuyService;

@Service("clientManifestBuyService")
public class ClientManifestBuyServiceImpl implements IClientManifestBuyService {
	
	@Resource
	private ManifestBuyMapper mManifestMapper;
	
	public int addManifest(ManifestBuy params) {
		return mManifestMapper.insert(params);
	}

}
