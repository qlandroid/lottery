package org.ql.shopping.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.lottery.StaticLotteryTypeMapper;
import org.ql.shopping.pojo.lottery.StaticLotteryType;
import org.ql.shopping.service.lottery.IStaticLotteryTypeService;
import org.springframework.stereotype.Service;

@Service("staticLotteryTypeService")
public class StaticLotteryTypeServiceImpl implements IStaticLotteryTypeService {

	@Resource
	private StaticLotteryTypeMapper mStaticLotteryTypeMapper;
	
	public int insert(StaticLotteryType params) {
		return mStaticLotteryTypeMapper.insert(params);
	}

	public List<StaticLotteryType> getTypeAll() {
		return mStaticLotteryTypeMapper.selectAll();
	}

	public List<StaticLotteryType> selectByType(String lotteryType) {
		List<StaticLotteryType> list = mStaticLotteryTypeMapper.selectByLotteryType(lotteryType);
		return list;
	}

}
