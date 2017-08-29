package org.ql.shopping.dao.lottery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;

import client.pojo.fill.FillOpenSearch;

public interface LotteryFillOpenMapper {
	int deleteByPrimaryKey(Integer lotteryFillOpenId);

	int insert(LotteryFillOpen record);

	int insertSelective(LotteryFillOpen record);

	LotteryFillOpen selectByPrimaryKey(Integer lotteryFillOpenId);

	int updateByPrimaryKeySelective(LotteryFillOpen record);

	int updateByPrimaryKey(LotteryFillOpen record);

	List<LotteryFillOpen> selectByParams(LotteryFillOpen params);

	List<LotteryFillOpenSearch> selectSearchByParams(
			LotteryFillOpenSearch params);

	int getSearchCountParams(LotteryFillOpenSearch params);

	FillOpenSearch selectBuyDetails(@Param("fOpenId") Integer fOpenId);
}