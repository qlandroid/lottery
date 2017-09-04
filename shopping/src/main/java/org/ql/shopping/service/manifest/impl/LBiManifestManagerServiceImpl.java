package org.ql.shopping.service.manifest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestLBiChangeMapper;
import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.ql.shopping.pojo.manifest.ManifestLBiChangeSearch;
import org.ql.shopping.service.manifest.ILBiManifestManagerService;
import org.ql.shopping.util.ModelUtils;
import org.springframework.stereotype.Service;

@Service("lBiManifestManagerService")
public class LBiManifestManagerServiceImpl implements ILBiManifestManagerService {


	@Resource
	private ManifestLBiChangeMapper mManifestLBiChangeMapper;
	
	
	public void addManifest(ManifestLBiChange manager) {
		mManifestLBiChangeMapper.insertSelective(manager);
	}

	public void updateById(ManifestLBiChange manager) {
		mManifestLBiChangeMapper.updateByPrimaryKey(manager);
	}

	public void deleteById(ManifestLBiChange manager) {
		mManifestLBiChangeMapper.deleteByPrimaryKey(manager.getChangeDocId());
	}

	public List<ManifestLBiChangeSearch> selectListPageByParams(
			ManifestLBiChangeSearch params) {
		ModelUtils.initPageParams(params);
		return mManifestLBiChangeMapper.selectListPageByParams(params);
	}

	public Integer getListCountByParams(ManifestLBiChangeSearch params) {
		return mManifestLBiChangeMapper.getListCountByParams(params);
	}

}
