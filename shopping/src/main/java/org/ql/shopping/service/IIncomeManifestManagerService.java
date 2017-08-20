package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.IncomeManifest;

public interface IIncomeManifestManagerService {

	public void createIncomeManifest(IncomeManifest params);
	
	/**
	 * 手动取消订单
	 * @param id
	 */
	public void cancelIncomeManifestById(Long id);
	
	/**
	 * 充值成功
	 * @param id
	 */
	public void incomeSuccessById(Long id);
	/**
	 * 充值成功 并添加备注 默认操作类型为充值
	 * @param id
	 */
	public void incomeSuccessById(Long id ,String remark);
	/**
	 * 充值成功 并添加备注 操作类型
	 * @param id
	 */
	public void incomeSuccessById(Long id ,String remark,String type);
	
	/**
	 * 交易超时，取消订单
	 * @param id
	 */
	public void timeOutCancelManifest(Long id);
	
	public void deleteBytId(IncomeManifest params);
	
	public void updateById(IncomeManifest params);
	
	public IncomeManifest findIncomeManifestById(Long id);
	
	public List<IncomeManifest> findPageAnd(IncomeManifest params);
	public List<IncomeManifest> findPageOr(IncomeManifest params);
	public Long getToatalCount(IncomeManifest params);
	
	public Long getParamsTotalCountAnd(IncomeManifest params);
	
	public Long getParamsTotalCountOr(IncomeManifest params);

}
