package client.service.lottery.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryFillOpenMapper;
import org.springframework.stereotype.Service;

import client.pojo.fill.FillOpenSearch;
import client.service.lottery.IClientFillOpenService;

@Service("clientFillOpenService")
public class ClientFillOpenService implements IClientFillOpenService {
	
	
	@Resource
	private LotteryFillOpenMapper mLotteryFillOpenMapper;
	
	
	public FillOpenSearch selectDetailsByOpenId(Integer openId) {
		FillOpenSearch details = mLotteryFillOpenMapper.selectBuyDetails(openId);
		
		return details;
	}

}
