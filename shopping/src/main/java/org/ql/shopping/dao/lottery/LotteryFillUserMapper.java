package org.ql.shopping.dao.lottery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ql.shopping.pojo.lottery.LotteryFillUser;

public interface LotteryFillUserMapper {
	int deleteByPrimaryKey(Integer lotteryFillUserId);

	int insert(LotteryFillUser record);

	int insertSelective(LotteryFillUser record);

	LotteryFillUser selectByPrimaryKey(Integer lotteryFillUserId);

	int updateByPrimaryKeySelective(LotteryFillUser record);

	int updateByPrimaryKey(LotteryFillUser record);

	/**
	 * 通过不同参数进行查询
	 * 
	 * @param params
	 * @return
	 */
	List<LotteryFillUser> selectByParams(LotteryFillUser params);

	Integer selectCountByParams(LotteryFillUser params);

	int getByLBiByOpenId(@Param("typeId") Integer openId);
}