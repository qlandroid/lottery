package org.ql.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.ILBiChangeManagerDao;
import org.ql.shopping.pojo.LBiChangeManager;
import org.ql.shopping.service.ILBiManifestManagerService;
import org.springframework.stereotype.Service;

@Service("lBiManifestManagerService")
public class LBiManifestManagerServiceImpl implements ILBiManifestManagerService {

	@Resource
	private ILBiChangeManagerDao mLBiChangeManagerDao;
	
	public void addManifest(LBiChangeManager manager) {
		mLBiChangeManagerDao.insert(manager);
	}

	public void updateById(LBiChangeManager manager) {
		mLBiChangeManagerDao.updateById(manager);
	}

	public void deleteById(LBiChangeManager manager) {
		mLBiChangeManagerDao.deleteById(manager.getChangeId());
	}

	public List<LBiChangeManager> findAnd(LBiChangeManager manager) {
		return mLBiChangeManagerDao.findAnd(manager);
	}

	public List<LBiChangeManager> findOr(LBiChangeManager manager) {
		return mLBiChangeManagerDao.findOr(manager);
	}

	public Long getTotalCount(LBiChangeManager manager) {
		return mLBiChangeManagerDao.getTotalCount(manager);
	}

	public Long getTotalCountOr(LBiChangeManager manager) {
		return mLBiChangeManagerDao.getTotalCountOr(manager);
	}

	public Long getTotalCountAnd(LBiChangeManager manager) {
		return mLBiChangeManagerDao.getTotalCountAnd(manager);
	}

}
