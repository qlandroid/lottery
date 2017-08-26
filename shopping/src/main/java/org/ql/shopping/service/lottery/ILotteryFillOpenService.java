package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryFillOpen;

public interface ILotteryFillOpenService {

	public int addFillOpen(LotteryFillOpen params);

	public int updateFillOpenById(LotteryFillOpen params);

	public List<LotteryFillOpen> selectByParams(LotteryFillOpen params);

	/**
	 * 通过彩票类型查询
	 * 
	 * @param typeId
	 * @return
	 */
	public List<LotteryFillOpen> selectByLotteryTypeId(Integer typeId);

	public LotteryFillOpen selectById(Integer lotteryId);

}
