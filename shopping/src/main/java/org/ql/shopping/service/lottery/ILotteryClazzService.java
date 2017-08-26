package org.ql.shopping.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.result.LotteryClazzTree;
import org.ql.shopping.pojo.result.ResultClazzTree;

public interface ILotteryClazzService {

	public int updateById(LotteryClazz params);

	public int delectById(LotteryClazz params);

	public int addClazz(LotteryClazz params);

	/**
	 * 查询全部
	 * 
	 * @param clazzId
	 * @return
	 */
	public List<LotteryClazz> findClazzByParentId(Integer parentId);

	public LotteryClazz selectByKey(Integer lotteryClazzParentId);

}
