package org.ql.shopping.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.dao.IIncomeManifestManagerDao;
import org.ql.shopping.dao.ILBiChangeManagerDao;
import org.ql.shopping.dao.IUserClientManagerDao;
import org.ql.shopping.pojo.IncomeManifest;
import org.ql.shopping.pojo.LBiChangeManager;
import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.service.IIncomeManifestManagerService;
import org.ql.shopping.util.MakeManifest;
import org.ql.shopping.util.MakeManifestNo;
import org.springframework.stereotype.Service;

@Service("incomeManifestManagerService")
public class IncomeManifestManagerServiceImpl implements IIncomeManifestManagerService {
	// 当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单
	public final static String STATUS_WAITING = "0";
	public final static String STATUS_SUCCESS = "1";
	public final static String STATUS_TIME_OUT = "2";
	public final static String STATUS_CANCEL = "3";

	@Resource
	private IIncomeManifestManagerDao mIncomeManifestManagerDao;
	@Resource
	private ILBiChangeManagerDao mLBiChangeManagerDao;
	@Resource
	private IUserClientManagerDao mUserClientMnagerDao;

	public void createIncomeManifest(IncomeManifest params) {
		params.setStatus(STATUS_WAITING);
		params.setCreateDate(new Date(System.currentTimeMillis()));
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
		i.setEndDate(new Date(System.currentTimeMillis()));
		i.setStatus(STATUS_CANCEL);
		mIncomeManifestManagerDao.updateById(i);
	}


	public void timeOutCancelManifest(Long id) {
		IncomeManifest i = new IncomeManifest();
		i.setIncomeId(id);
		i.setEndDate(new Date(System.currentTimeMillis()));
		i.setStatus(STATUS_TIME_OUT);
		mIncomeManifestManagerDao.updateById(i);
	}

	/**
	 * 充值成功 修改订单状态， 获得当前用户的积分值， 为用户充值，改变用户详情 充值后的金额保存到任务单 插入 积分变更表中
	 */
	public void incomeSuccessById(Long id) {
		incomeSuccessById(id,"");
	}
	public void incomeSuccessById(Long id, String remark) {
		incomeSuccessById(id,remark,C.CHANGE_OPERATE_TYPE_INCOME);
	}
	public void incomeSuccessById(Long id, String remark,String operateType) {
		// 通过id,查询到当前交易成功的 详情
		IncomeManifest i = new IncomeManifest();
		i.setIncomeId(id);
		List<IncomeManifest> list = mIncomeManifestManagerDao.findAnd(i);
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
		incomeDoc.setStatus(STATUS_SUCCESS);
		Date nowDate = new Date(System.currentTimeMillis());
		incomeDoc.setEndDate(nowDate);
		mIncomeManifestManagerDao.updateById(incomeDoc);

		// 插入积分变换表
		LBiChangeManager insertChangeManifest = new LBiChangeManager();
		insertChangeManifest.setRemark(remark);
		insertChangeManifest.setDocIncomeId(incomeDoc.getIncomeId());
		insertChangeManifest.setOperateDate(new Date(System.currentTimeMillis()));
		insertChangeManifest.setType(C.CHANGE_TYPE_INCOME);
		insertChangeManifest.setType(C.CHANGE_OPERATE_TYPE_INCOME);
		insertChangeManifest.setUserId(incomeDoc.getUserId());
		insertChangeManifest.setOperateType(operateType);
		insertChangeManifest.setType(C.CHANGE_TYPE_INCOME);
		mLBiChangeManagerDao.insert(insertChangeManifest);
	}

}
