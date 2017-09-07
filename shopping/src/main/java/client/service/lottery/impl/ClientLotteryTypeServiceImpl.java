package client.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.LotteryTypeMapper;
import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.springframework.stereotype.Service;

import client.service.lottery.IClientLotteryTypeService;

@Service("clientLotteryTypeService")
public class ClientLotteryTypeServiceImpl implements IClientLotteryTypeService {

	@Resource
	private LotteryTypeMapper mLotteryTypeMapper;
	
	public List<LotteryTypeSearch> selectAll() {
		return mLotteryTypeMapper.selectAll();
	}

	public Integer getAllCount() {
		return mLotteryTypeMapper.getAllCount();
	}

}
