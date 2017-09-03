package client.service.lottery;

import java.util.List;

import client.pojo.fill.FillOpenSearch;
import client.pojo.lottery.ClientLotteryFillOpenSearch;

public interface IClientFillOpenService {
	
	FillOpenSearch selectDetailsByOpenId(Integer openId);


	List<ClientLotteryFillOpenSearch> selectFillOpenList(ClientLotteryFillOpenSearch params);


	/**
	 * 查询数量
	 * @param params
	 * @return
	 */
	long getFillOpenList(ClientLotteryFillOpenSearch params);


	FillOpenSearch selectByDocNo(String docNo);

}
