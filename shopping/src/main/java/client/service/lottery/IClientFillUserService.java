package client.service.lottery;

import org.ql.shopping.pojo.lottery.LotteryFillUser;

import client.pojo.fill.FillUserPaySearch;

public interface IClientFillUserService {

	/**
	 * 用于查询购买彩票的用户，并且已经支付费用
	 * 
	 * @param openId
	 * @return
	 */
	Double selectOverBuyByOpenId(Integer openId);

	/**
	 * 通过支付任务单查询 所要支付的彩票
	 * 
	 * @param docNo
	 * @return
	 */
	FillUserPaySearch selectByDocNo(String docNo);

	void updateStatus(LotteryFillUser updateBuyLotteryP);
}
