package org.ql.shopping.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryFillUserMapper;
import org.ql.shopping.pojo.Model;
import org.ql.shopping.pojo.lottery.LotteryFillUser;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.util.ModelUtils;
import org.springframework.stereotype.Service;

@Service("lotteryFillUserService")
public class LotteryFillUserServiceImpl implements ILotteryFillUserService {

	@Resource
	private LotteryFillUserMapper mLotteryFillUserMapper;
	
	public int addFillLottery(LotteryFillUser params) {
		return mLotteryFillUserMapper.insertSelective(params);
	}

	public int updateFillLotteryByKey(LotteryFillUser params) {
		return mLotteryFillUserMapper.updateByPrimaryKeySelective(params);
	}

	public List<LotteryFillUser> selectByParams(LotteryFillUser params) {
		ModelUtils.initPageParams(params);
		return mLotteryFillUserMapper.selectByParams(params);
	}

	public List<LotteryFillUser> selectByUserId(Integer userId) {
		LotteryFillUser params = new LotteryFillUser();
		ModelUtils.initPageParams(params);
		params.setUserId(userId);
		
		return mLotteryFillUserMapper.selectByParams(params);
	}


	public List<LotteryFillUser> selectAllByOpenId(LotteryFillUser params) {
		ModelUtils.initPageParams(params);
		return mLotteryFillUserMapper.selectByParams(params);
	}


	public LotteryFillUser selectByKey(Integer key) {
		return mLotteryFillUserMapper.selectByPrimaryKey(key);
	}

	public List<LotteryFillUser> selectByUserId(LotteryFillUser userId) {
		ModelUtils.initPageParams(userId);
		return mLotteryFillUserMapper.selectByParams(userId);
	}

	public Integer selectCountByOpenId(Integer openId) {
		LotteryFillUser params = new LotteryFillUser();
		params.setLotteryFillOpenId(openId);
		return mLotteryFillUserMapper.selectCountByParams(params);
	}

	public int getBuyLBiByOpenId(Integer openId) {
		return mLotteryFillUserMapper.getByLBiByOpenId(openId);
	}

}
