package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.IncomeManifest;

public interface IIncomeManifestManagerDao {

	public void insert(IncomeManifest params);

	public void delete(IncomeManifest params);

	public void updateById(IncomeManifest params);

	public List<IncomeManifest> findById(IncomeManifest params);

	public List<IncomeManifest> findAnd(IncomeManifest params);

	public List<IncomeManifest> findOr(IncomeManifest params);

	public Long getTotalCount();

	public Long getParamsTotalCountAnd(IncomeManifest params);

	public Long getParamsTotalCountOr(IncomeManifest params);

	/**
	 * 获得支付金额的总额
	 * 
	 * @return
	 */
	public Double sumPayMoney(IncomeManifest params);

	/**
	 * 获得充值积分的总额
	 * 
	 * @return
	 */
	public Double sumIncomeInQty(IncomeManifest params);

}
