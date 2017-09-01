package client.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryFillOpenMapper;
import org.ql.shopping.util.ModelUtils;
import org.springframework.stereotype.Service;

import client.pojo.fill.FillOpenSearch;
import client.pojo.lottery.ClientLotteryFillOpenSearch;
import client.service.lottery.IClientFillOpenService;

@Service("clientFillOpenService")
public class ClientFillOpenService implements IClientFillOpenService {
	
	
	@Resource
	private LotteryFillOpenMapper mLotteryFillOpenMapper;
	
	
	public FillOpenSearch selectDetailsByOpenId(Integer openId) {
		FillOpenSearch details = mLotteryFillOpenMapper.selectBuyDetails(openId);
		
		return details;
	}


	public List<ClientLotteryFillOpenSearch> selectFillOpenList(ClientLotteryFillOpenSearch params) {
		ModelUtils.initPageParams(params);
		List<ClientLotteryFillOpenSearch> list = mLotteryFillOpenMapper.selectClientListByClazzAndTypePage(params);
		return list;
	}


	public long getFillOpenList(ClientLotteryFillOpenSearch params) {
		return mLotteryFillOpenMapper.getClientOpenFillCount(params);
	}



}
