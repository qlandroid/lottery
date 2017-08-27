package org.ql.shopping.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryFillOpenMapper;
import org.ql.shopping.pojo.Model;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.util.ModelUtils;
import org.springframework.stereotype.Service;

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

	public List<LotteryFillOpenSearch> selectSearchByParams(LotteryFillOpenSearch params) {
		ModelUtils.initPageParams(params);
		return mLotteryFillOpenMapper.selectSearchByParams(params);
	}

}
