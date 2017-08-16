package org.ql.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.ILotterySSQDao;
import org.ql.shopping.pojo.LotterySSQ;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.service.ILotteryService;
import org.springframework.stereotype.Service;

@Service("lotterySSQService")
public class LotterySSQServiceImpl implements ILotteryService {
	@Resource
	private ILotterySSQDao mLotterySSQDao;

	public List<LotterySSQ> findAll(ListParams params) {
		int page = params.getPage();
		int pageSize = params.getPageSize();
		
		int firstIndex = (page - 1) * pageSize;
		int footIndex = page * pageSize;
		params.setFirstIndex(firstIndex);
		params.setFootIndex(footIndex);
		return mLotterySSQDao.findAll(params);
	}

	public int queryTotalCount(ListParams params) {
		return mLotterySSQDao.queryTotalCount(params);
	}

}
