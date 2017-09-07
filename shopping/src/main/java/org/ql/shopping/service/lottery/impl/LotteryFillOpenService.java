package org.ql.shopping.service.lottery.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.dao.lottery.LotteryFillOpenMapper;
import org.ql.shopping.pojo.Model;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.util.LotteryStageUtils;
import org.ql.shopping.util.ModelUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import client.pojo.fill.FillOpenSearch;

@Service("lotteryFillOpenService")
public class LotteryFillOpenService implements ILotteryFillOpenService {

	@Resource
	private LotteryFillOpenMapper mLotteryFillOpenMapper;

	public synchronized int addFillOpen(LotteryFillOpen params) {
		return mLotteryFillOpenMapper.insertSelective(params);
	}

	public int updateFillOpenById(LotteryFillOpen params) {
		return mLotteryFillOpenMapper.updateByPrimaryKeySelective(params);
	}

	public List<LotteryFillOpen> selectByLotteryTypeId(Integer typeId) {
		LotteryFillOpen p = new LotteryFillOpen();
		p.setLotteryTypeId(typeId);
		return mLotteryFillOpenMapper.selectByParams(p);
	}

	public LotteryFillOpen selectById(Integer lotteryId) {
		return mLotteryFillOpenMapper.selectByPrimaryKey(lotteryId);
	}

	public synchronized int getSearchCountParams(LotteryFillOpenSearch params) {
		return mLotteryFillOpenMapper.getSearchCountParams(params);
	}

	public List<LotteryFillOpen> selectByParams(LotteryFillOpen params) {
		return mLotteryFillOpenMapper.selectByParams(params);
	}

	public List<LotteryFillOpenSearch> selectSearchByParams(
			LotteryFillOpenSearch params) {
		ModelUtils.initPageParams(params);
		return mLotteryFillOpenMapper.selectSearchByParams(params);
	}

	public LotteryFillOpenSearch getFillOpenModelByTypeId(Integer lotteryTypeId) {
		List<LotteryFillOpenSearch> list = mLotteryFillOpenMapper
				.selectByTypeId(lotteryTypeId);
		if (list == null || list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	public synchronized LotteryFillOpenSearch createFillOpenByTypeId(
			Integer createUserId, LotteryFillOpenSearch params) {
		LotteryFillOpenSearch fillOpenModel = getFillOpenModelByTypeId(params
				.getLotteryTypeId());
		if (!StringUtils.isEmpty(params.getLotteryFillName())) {
			fillOpenModel.setLotteryFillName(params.getLotteryFillName());
		}

		LotteryFillOpenSearch createFillOpen = new LotteryFillOpenSearch();
		createFillOpen.setLotteryTypeId(params.getLotteryTypeId());
		createFillOpen.setFillLBi(fillOpenModel.getFillLBi());
		createFillOpen.setAwardLBi(fillOpenModel.getAwardLBi());

		createFillOpen.setLotteryFillName(fillOpenModel.getLotteryFillName());
		createFillOpen.setCreateUserId(createUserId);
		createFillOpen.setLotteryFillCreaterDate(new Date());
		createFillOpen.setLotteryFillUnitPrice(fillOpenModel
				.getLotteryFillUnitPrice());

		mLotteryFillOpenMapper.insertSelective(createFillOpen);
		
		
		String createStage = LotteryStageUtils.createStage(
				C.LotteryStageFlag.FILL, createFillOpen.getLotteryFillOpenId());

		LotteryFillOpen updateStage = new LotteryFillOpenSearch();
		updateStage.setLotteryFillOpenId(createFillOpen.getLotteryFillOpenId());
		updateStage.setLotteryStage(createStage);
		mLotteryFillOpenMapper.updateByPrimaryKeySelective(updateStage);
		
		createFillOpen.setLotteryStage(createStage);
		return createFillOpen;
	}

}
