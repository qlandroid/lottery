package org.ql.shopping.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryFillOpenMapper;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.springframework.stereotype.Service;

@Service("lotteryFillOpenService")
public class LotteryFillOpenService implements ILotteryFillOpenService {

	@Resource
	private LotteryFillOpenMapper mLotteryFillOpenMapper;

	public int addFillOpen(LotteryFillOpen params) {
		return mLotteryFillOpenMapper.insertSelective(params);
	}

	public int updateFillOpenById(LotteryFillOpen params) {
		return mLotteryFillOpenMapper.updateByPrimaryKeySelective(params);
	}

	public List<LotteryFillOpen> selectByParams(LotteryFillOpen params) {
		return mLotteryFillOpenMapper.selectByParams(params);
	}

	public List<LotteryFillOpen> selectByLotteryTypeId(Integer typeId) {
		LotteryFillOpen p = new LotteryFillOpen();
		p.setLotteryTypeId(typeId);
		return mLotteryFillOpenMapper.selectByParams(p);
	}

	public LotteryFillOpen selectById(Integer lotteryId) {
		return mLotteryFillOpenMapper.selectByPrimaryKey(lotteryId);
	}

}
