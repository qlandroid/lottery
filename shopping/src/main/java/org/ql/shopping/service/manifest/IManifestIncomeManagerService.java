package org.ql.shopping.service.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.IncomeManifest;
import org.ql.shopping.pojo.manifest.ManifestIncomeSearch;

public interface IManifestIncomeManagerService {

	/**
	 * 创建订单 pay_money不能为空 income_in_qty 不能为空 user_id不能为空
	 * 
	 * @param params
	 */
	public void createIncomeManifest(IncomeManifest params);

	/**
	 * 手动取消订单
	 * 
	 * @param id
	 */
	public void cancelIncomeManifestById(Long id);

	/**
	 * 充值成功
	 * 
	 * @param id
	 */
	public void incomeSuccessById(Long id);

	/**
	 * 充值成功 并添加备注 默认操作类型为 任务单创建
	 * 
	 * @param id
	 */
	public void incomeSuccessById(Long id, String remark);

	/**
	 * 充值成功 并添加备注 操作类型
	 * 
	 * @param id
	 */
	public void incomeSuccessById(Long id, String remark, String operatetype);

	/**
	 * 交易超时，取消订单
	 * 
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

	/**
	 * 获得条件下所有支付金额 的总额， 传null则查询全部
	 * 
	 * @param params
	 * @return
	 */
	public Double getTotalPayMoney(IncomeManifest params);

	/**
	 * 获得条件下所有充值积分的总额
	 * 
	 * @param parms
	 * @return
	 */
	public Double getTotalIncomeInQty(IncomeManifest parms);

	/**
	 * 条件查询，并创建时间排序
	 * 
	 * @param params
	 * @return
	 */
	public List<ManifestIncomeSearch> searchPageOrderByCreateDate(ManifestIncomeSearch params);

	public long getSearchPageCount(ManifestIncomeSearch params);
}
