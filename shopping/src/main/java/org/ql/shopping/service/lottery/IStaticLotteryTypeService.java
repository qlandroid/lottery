package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.StaticLotteryType;

public interface IStaticLotteryTypeService {

	int insert(StaticLotteryType params);
	List<StaticLotteryType> getTypeAll();
	List<StaticLotteryType> selectByType(String lotteryType);
}
