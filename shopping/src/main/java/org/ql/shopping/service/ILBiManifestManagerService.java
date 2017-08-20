package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.LBiChangeManager;

public interface ILBiManifestManagerService {
	
	public void addManifest(LBiChangeManager manager);
	
	public void updateById(LBiChangeManager manager);
	
	public void deleteById(LBiChangeManager manager);
	
	public List<LBiChangeManager> findAnd(LBiChangeManager manager);
	
	public List<LBiChangeManager> findOr(LBiChangeManager manager);
	
	public Long getTotalCount(LBiChangeManager manager);
	
	public Long getTotalCountOr(LBiChangeManager manager);
	
	public Long getTotalCountAnd(LBiChangeManager manager);
	
}
