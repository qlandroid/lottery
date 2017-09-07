package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;

public interface ILotteryFillOpenService {

	public int addFillOpen(LotteryFillOpen params);

	public int updateFillOpenById(LotteryFillOpen params);
	public List<LotteryFillOpen> selectByParams(LotteryFillOpen params);
	public List<LotteryFillOpenSearch> selectSearchByParams(LotteryFillOpenSearch params);

	/**
	 * 通过彩票类型查询
	 * 
	 * @param typeId
	 * @return
	 */
	public List<LotteryFillOpen> selectByLotteryTypeId(Integer typeId);

	public LotteryFillOpen selectById(Integer lotteryId);

	public int getSearchCountParams(LotteryFillOpenSearch params);

	/**
	 * 通过彩票类型，创建彩票
	 * @param lotteryTypeId
	 * @return
	 */
	public LotteryFillOpenSearch getFillOpenModelByTypeId(Integer lotteryTypeId);

	public LotteryFillOpenSearch createFillOpenByTypeId(Integer createUserId,LotteryFillOpenSearch params);
	
	
	
}
