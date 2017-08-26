package org.ql.shopping.dao.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryFillOpen;

public interface LotteryFillOpenMapper {
	int deleteByPrimaryKey(Integer lotteryFillOpenId);

	int insert(LotteryFillOpen record);

	int insertSelective(LotteryFillOpen record);

	LotteryFillOpen selectByPrimaryKey(Integer lotteryFillOpenId);

	int updateByPrimaryKeySelective(LotteryFillOpen record);

	int updateByPrimaryKey(LotteryFillOpen record);

	List<LotteryFillOpen> selectByParams(LotteryFillOpen params);

}