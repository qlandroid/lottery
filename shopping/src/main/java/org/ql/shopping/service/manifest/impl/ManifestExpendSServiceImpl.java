package org.ql.shopping.service.manifest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestExpendMapper;
import org.ql.shopping.pojo.manifest.ManifestExpendSs;
import org.ql.shopping.service.manifest.IManifestExpendSService;
import org.ql.shopping.util.ModelUtils;
import org.springframework.stereotype.Service;

@Service("manifestExpendSService")
public class ManifestExpendSServiceImpl implements IManifestExpendSService{
	
	@Resource
	private ManifestExpendMapper mManifestExpendMapper;

	public List<ManifestExpendSs> selectListByParams(ManifestExpendSs params) {
		ModelUtils.initPageParams(params);
		return mManifestExpendMapper.selectDetailsListPageByParams(params);
	}
	public Integer getListCountByParams(ManifestExpendSs params){
		return mManifestExpendMapper.getListCountByParams(params);
	}

}
