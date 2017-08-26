package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.ql.shopping.pojo.lottery.LotteryTypeWithBLOBs;

public interface ILotteryTypeService {

	public int addType(LotteryTypeSearch params);

	
	public List<LotteryTypeWithBLOBs> selectByLotteryClazzId(Integer clazzId);
}
