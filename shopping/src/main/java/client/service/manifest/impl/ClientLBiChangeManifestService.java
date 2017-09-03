package client.service.manifest.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestLBiChangeMapper;
import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.springframework.stereotype.Service;

import client.service.manifest.IClientLBiChangeManifestService;

@Service("clientLBiChangeManifestService")
public class ClientLBiChangeManifestService implements IClientLBiChangeManifestService{

	
	@Resource
	private ManifestLBiChangeMapper mManifestLBiChangeMapper;
	
	public void insert(ManifestLBiChange params) {
		mManifestLBiChangeMapper.insertSelective(params);
	}

}
