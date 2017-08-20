package org.ql.shopping.dao;

import java.util.List;

import org.ql.shopping.pojo.IncomeManifest;

public interface IIncomeManifestManagerDao {

	
	public void insert(IncomeManifest params);
	
	public void delete(IncomeManifest params);
	
	public void updateById(IncomeManifest params);
	
	public List<IncomeManifest> findAnd(IncomeManifest params);
	public List<IncomeManifest> findOr(IncomeManifest params);

	public Long getTotalCount();
	
	public Long getParamsTotalCountAnd(IncomeManifest params);
	public Long getParamsTotalCountOr(IncomeManifest params);

}