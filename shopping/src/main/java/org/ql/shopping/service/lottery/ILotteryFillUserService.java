package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.FillUserDetails;
import org.ql.shopping.pojo.lottery.LotteryFillUser;

public interface ILotteryFillUserService {

	int addFillLottery(LotteryFillUser params);

	int updateFillLotteryByKey(LotteryFillUser params);

	/**
	 * 通过条件查询，带分页
	 * 
	 * @param params
	 * @return
	 */
	List<LotteryFillUser> selectPageByParams(LotteryFillUser params);

	/**
	 * 通过用户id查询所有购买过的彩票 ，
	 * 
	 * @param userId
	 * @return
	 */
	List<LotteryFillUser> selectByUserId(LotteryFillUser userId);

	/**
	 * 通过开奖彩票的 ID ，查询用户购买过的彩票的集合
	 * 
	 * @param openId
	 * @return
	 */
	List<LotteryFillUser> selectPageByOpenId(LotteryFillUser openId);

	/**
	 * 通过开奖 ID 获取 用户购买的数量;
	 * 
	 * @param openId
	 * @return
	 */
	int getBuyLBiByOpenId(Integer openId);

	/**
	 * 通过开奖彩票的id 获取购买该彩票的所有数量
	 * 
	 * @param count
	 * @return
	 */
	Integer selectCountByOpenId(Integer openId);

	/**
	 * 通过主键查询
	 * 
	 * @param key
	 * @return
	 */
	LotteryFillUser selectByKey(Integer key);

	/**
	 * 通过彩票查询 已经购买成功的用户详情集合
	 * 
	 * @param openId
	 * @return
	 */
	List<FillUserDetails> selectUserDetailsByOpenId(Integer openId);
	

}
