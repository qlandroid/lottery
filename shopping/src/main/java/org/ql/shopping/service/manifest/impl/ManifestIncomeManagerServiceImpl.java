package org.ql.shopping.service.manifest.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.dao.manifest.IIncomeManifestManagerDao;
import org.ql.shopping.dao.manifest.ILBiChangeManagerDao;
import org.ql.shopping.dao.manifest.ManifestIncomeMapper;
import org.ql.shopping.dao.user.IUserClientManagerDao;
import org.ql.shopping.pojo.manifest.IncomeManifest;
import org.ql.shopping.pojo.manifest.LBiChangeManager;
import org.ql.shopping.pojo.manifest.ManifestIncomeSearch;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.service.manifest.IManifestIncomeManagerService;
import org.ql.shopping.util.MakeManifest;
import org.springframework.stereotype.Service;

@Service("manifestIncomeManagerService")
public class ManifestIncomeManagerServiceImpl implements IManifestIncomeManagerService {

	@Resource
	private IIncomeManifestManagerDao mIncomeManifestManagerDao;
	@Resource
	private ILBiChangeManagerDao mLBiChangeManagerDao;
	@Resource
	private IUserClientManagerDao mUserClientMnagerDao;
	@Resource
	private ManifestIncomeMapper mManifestIncomeMapper;

	public void createIncomeManifest(IncomeManifest params) {
		params.setStatus(C.ManifestIncome.INCOME_STATUS_WAITING);
		params.setCreateDate(new Timestamp(System.currentTimeMillis()));
		// 生成订单号
		String manifestNo = MakeManifest.makeIncomeManifestNo();
		params.setIncomeDocNo(manifestNo);
		mIncomeManifestManagerDao.insert(params);
	}

	public void deleteBytId(IncomeManifest params) {
		mIncomeManifestManagerDao.delete(params);
	}

	public void updateById(IncomeManifest params) {
		mIncomeManifestManagerDao.updateById(params);
	}

	public IncomeManifest findIncomeManifestById(Long id) {
		IncomeManifest params = new IncomeManifest();
		params.setIncomeId(id);
		List<IncomeManifest> list = mIncomeManifestManagerDao.findAnd(params);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public List<IncomeManifest> findPageAnd(IncomeManifest params) {
		setPageAndSise(params);
		return mIncomeManifestManagerDao.findAnd(params);
	}

	public List<IncomeManifest> findPageOr(IncomeManifest params) {
		setPageAndSise(params);
		return mIncomeManifestManagerDao.findOr(params);
	}

	private void setPageAndSise(IncomeManifest params) {
		Long page = params.getPage();
		Integer pageSize = params.getPageSize();

		if (page == null || page <= 0) {
			params.setPage(1L);
		}
		if (pageSize == null || pageSize <= 0) {
			params.setPageSize(C.PAGE_SIZE);
		}
		params.setFirstIndex((params.getPage() - 1) * params.getPageSize());
	}

	public Long getToatalCount(IncomeManifest params) {
		return mIncomeManifestManagerDao.getTotalCount();
	}

	public Long getParamsTotalCountAnd(IncomeManifest params) {
		return mIncomeManifestManagerDao.getParamsTotalCountAnd(params);
	}

	public Long getParamsTotalCountOr(IncomeManifest params) {
		return mIncomeManifestManagerDao.getParamsTotalCountOr(params);
	}

	public void cancelIncomeManifestById(Long id) {
		IncomeManifest i = new IncomeManifest();
		i.setIncomeId(id);
		i.setEndDate(new Timestamp(System.currentTimeMillis()));
		i.setStatus(C.ManifestIncome.INCOME_STATUS_CANCEL);
		mIncomeManifestManagerDao.updateById(i);
	}

	public void timeOutCancelManifest(Long id) {
		IncomeManifest i = new IncomeManifest();
		i.setIncomeId(id);
		i.setEndDate(new Timestamp(System.currentTimeMillis()));
		i.setStatus(C.ManifestIncome.INCOME_STATUS_TIME_OUT);
		mIncomeManifestManagerDao.updateById(i);
	}

	/**
	 * 充值成功 修改订单状态， 获得当前用户的积分值， 为用户充值，改变用户详情 充值后的金额保存到任务单 插入 积分变更表中
	 */
	public void incomeSuccessById(Long id) {
		incomeSuccessById(id, "");
	}

	public void incomeSuccessById(Long id, String remark) {
		incomeSuccessById(id, remark, C.CHANGE_OPERATE_TYPE_INCOME);
	}

	public void incomeSuccessById(Long id, String remark, String operateType) {
		// 通过id,查询到当前交易成功的 详情
		IncomeManifest i = new IncomeManifest();
		i.setIncomeId(id);
		List<IncomeManifest> list = mIncomeManifestManagerDao.findById(i);
		IncomeManifest incomeDoc = list.get(0);

		// 通过用户Id查询当前用户详情
		UserClientManagerParams params = new UserClientManagerParams();
		params.setId(incomeDoc.getUserId());
		List<UserClient> clientList = mUserClientMnagerDao.findUser(params);
		UserClient client = clientList.get(0);

		// 获得用户的当前积分
		Double beforeQty = client.getlBi();
		// 获得充值的积分数量；
		Double inQty = incomeDoc.getInQty();
		// 充值后的金额
		Double afterQty = beforeQty + inQty;

		// 更新用户 积分
		UserClient afterClient = new UserClient();
		afterClient.setId(client.getId());
		afterClient.setlBi(afterQty);
		mUserClientMnagerDao.updateLBi(afterClient);

		// 更新当前充值表
		incomeDoc.setAfterQty(afterQty);
		incomeDoc.setBeforeQty(beforeQty);
		incomeDoc.setStatus(C.ManifestIncome.INCOME_STATUS_SUCCESS);
		Timestamp nowDate = new Timestamp(System.currentTimeMillis());
		incomeDoc.setEndDate(nowDate);
		mIncomeManifestManagerDao.updateById(incomeDoc);

		// 插入积分变换表
		LBiChangeManager insertChangeManifest = new LBiChangeManager();
		insertChangeManifest.setRemark(remark);
		insertChangeManifest.setDocIncomeId(incomeDoc.getIncomeId());
		insertChangeManifest.setOperateDate(new Timestamp(System.currentTimeMillis()));
		insertChangeManifest.setType(C.CHANGE_TYPE_INCOME);
		insertChangeManifest.setType(C.CHANGE_OPERATE_TYPE_INCOME);
		insertChangeManifest.setUserId(incomeDoc.getUserId());
		insertChangeManifest.setOperateType(operateType);
		insertChangeManifest.setType(C.CHANGE_TYPE_INCOME);
		mLBiChangeManagerDao.insert(insertChangeManifest);
	}

	public Double getTotalPayMoney(IncomeManifest params) {
		return mIncomeManifestManagerDao.sumPayMoney(params);
	}

	public Double getTotalIncomeInQty(IncomeManifest params) {
		return mIncomeManifestManagerDao.sumIncomeInQty(params);
	}

	public List<ManifestIncomeSearch> searchPageOrderByCreateDate(ManifestIncomeSearch params) {

		return mManifestIncomeMapper.searchPageOrderByCreateDate(params);
	}

	public long getSearchPageCount(ManifestIncomeSearch params) {
		return mManifestIncomeMapper.getSearchPageCount(params);
	}

}
