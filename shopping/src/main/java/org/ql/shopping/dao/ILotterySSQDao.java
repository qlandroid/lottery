package org.ql.shopping.dao;

import java.util.List;

import org.ql.shopping.pojo.LotterySSQ;
import org.ql.shopping.pojo.params.ListParams;

public interface ILotterySSQDao {
	
	public int addLottery(LotterySSQ lottery); 
	
	public List<LotterySSQ> find(LotterySSQ lottery);

	public List<LotterySSQ> findAll(ListParams params);
	
	public int deleteOfId(int id);
	
	public int queryTotalCount(ListParams params);
}
