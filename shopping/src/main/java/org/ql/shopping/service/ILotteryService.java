package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.LotterySSQ;
import org.ql.shopping.pojo.params.ListParams;

public interface ILotteryService {
	
	public List<LotterySSQ> findAll(ListParams params);

	public int queryTotalCount(ListParams params);
	
}
