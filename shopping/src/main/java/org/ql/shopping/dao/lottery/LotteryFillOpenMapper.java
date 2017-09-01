package org.ql.shopping.dao.lottery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;

import client.pojo.fill.FillOpenSearch;
import client.pojo.lottery.ClientLotteryFillOpenSearch;

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
	
	/**
	 * 分页查询，必须传参数 pageSize ,page,clazz,type;
	 * 通过 大类 和彩票类型进行查询
	 * @param params
	 * @return
	 */
	List<ClientLotteryFillOpenSearch> selectClientListByClazzAndTypePage(ClientLotteryFillOpenSearch params);

	long getClientOpenFillCount(ClientLotteryFillOpenSearch params);
}