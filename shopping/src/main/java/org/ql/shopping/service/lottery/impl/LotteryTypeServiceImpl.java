package org.ql.shopping.service.lottery.impl;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Result;
import org.ql.shopping.dao.lottery.LotteryTypeMapper;
import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.ql.shopping.service.lottery.ILotteryTypeService;
import org.springframework.stereotype.Service;

@Service("lotteryTypeService")
public class LotteryTypeServiceImpl implements ILotteryTypeService {

	@Resource
	private LotteryTypeMapper mLotteryTypeMapper;
	
	public int addType(LotteryTypeSearch params) {
		return mLotteryTypeMapper.insert(params);
	}

}
