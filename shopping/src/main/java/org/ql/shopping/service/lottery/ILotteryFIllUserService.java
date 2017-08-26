package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryFillUser;

public interface ILotteryFIllUserService {

	int addFillLottery(LotteryFillUser params);

	int updateFillLotteryByKey(LotteryFillUser params);

	/**
	 * 通过条件查询，带分页
	 * 
	 * @param params
	 * @return
	 */
	List<LotteryFillUser> selectByParams(LotteryFillUser params);

	/**
	 * 通过用户id查询所有购买过的彩票 ，
	 * 
	 * @param userId
	 * @return
	 */
	List<LotteryFillUser> selectByUserId(Integer userId);

	/**
	 * 通过开奖彩票的id 获取所有中奖人
	 * 
	 * @param openId 所属创建彩票的id
	 * @return 
	 */
	List<LotteryFillUser> selectAwardUserByOpenNumber(Integer openId);

	
	/**
	 * 通过开奖彩票的 ID ，查询用户购买过的彩票的集合
	 * @param openId
	 * @return
	 */
	List<LotteryFillUser> selectAllByOpenId(Integer openId);
	
	/**
	 * 通过开奖彩票的id 获取购买该彩票的所有数量
	 * @param count
	 * @return
	 */
	Integer selectCountByOpenId(Integer count);
	
	/**
	 * 通过主键查询
	 * 
	 * @param key
	 * @return
	 */
	LotteryFillUser selectByKey(Integer key);

}
