package org.ql.shopping.service.lottery.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.dao.lottery.LotteryClazzMapper;
import org.ql.shopping.dao.lottery.LotteryTypeMapper;
import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.lottery.LotteryClazzSearch;
import org.ql.shopping.pojo.lottery.LotteryTypeSearch;
import org.ql.shopping.pojo.lottery.LotteryTypeWithBLOBs;
import org.ql.shopping.pojo.result.LotteryClazzTree;
import org.ql.shopping.pojo.result.ResultClazzTree;
import org.ql.shopping.service.lottery.ILotteryClazzService;
import org.springframework.stereotype.Service;

@Service("lotteryClazzService")
public class LotteryClazzServiceImpl implements ILotteryClazzService {

	@Resource
	LotteryClazzMapper mLotteryClazzMapper;

	public int updateById(LotteryClazz params) {
		return mLotteryClazzMapper.updateByPrimaryKeyWithBLOBs(params);
	}

	public int delectById(LotteryClazz params) {
		return mLotteryClazzMapper.deleteByPrimaryKey(params.getLotteryClazzId());
	}

	public int addClazz(LotteryClazz params) {
		return mLotteryClazzMapper.insertSelective(params);
	}

	public List<LotteryClazz> findClazzByParentId(Integer parentId) {
		List<LotteryClazz> clazzList = mLotteryClazzMapper.selectByParentId(parentId);
		return clazzList;
	}
	
	public LotteryClazz selectByKey(Integer id) {
		return mLotteryClazzMapper.selectByPrimaryKey(id);
	}

	
}
