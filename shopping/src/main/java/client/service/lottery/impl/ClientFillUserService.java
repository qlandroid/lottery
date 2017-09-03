package client.service.lottery.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryFillUserMapper;
import org.ql.shopping.pojo.lottery.LotteryFillUser;
import org.springframework.stereotype.Service;

import client.pojo.fill.FillUserPaySearch;
import client.service.lottery.IClientFillUserService;

@Service("clientFillUserService")
public class ClientFillUserService implements IClientFillUserService {

	@Resource
	private LotteryFillUserMapper mFillUserMapper;
	
	
	public Double selectOverBuyByOpenId(Integer openId) {
		return mFillUserMapper.selectOverBuyByOpenId(openId);
	}


	public FillUserPaySearch selectByDocNo(String docNo) {
		
		return mFillUserMapper.selectByDocNo(docNo);
	}


	public void updateStatus(LotteryFillUser updateBuyLotteryP) {
		mFillUserMapper.updateByPrimaryKeySelective(updateBuyLotteryP);
	}

}
