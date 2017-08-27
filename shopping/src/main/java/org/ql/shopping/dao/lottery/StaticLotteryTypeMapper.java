package org.ql.shopping.dao.lottery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ql.shopping.pojo.lottery.StaticLotteryType;

public interface StaticLotteryTypeMapper {
    int deleteByPrimaryKey(Integer staticLotteryTypeId);

    int insert(StaticLotteryType record);

    int insertSelective(StaticLotteryType record);

    StaticLotteryType selectByPrimaryKey(Integer staticLotteryTypeId);

    int updateByPrimaryKeySelective(StaticLotteryType record);

    int updateByPrimaryKeyWithBLOBs(StaticLotteryType record);

    int updateByPrimaryKey(StaticLotteryType record);
    
    List<StaticLotteryType> selectAll();

	List<StaticLotteryType> selectByLotteryType(@Param("type") String lotteryType);
}