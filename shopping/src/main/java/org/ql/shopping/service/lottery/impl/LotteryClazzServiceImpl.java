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
import org.ql.shopping.service.lottery.ILotteryClazzService;
import org.springframework.stereotype.Service;

@Service("lotteryClazzService")
public class LotteryClazzServiceImpl implements ILotteryClazzService {

	@Resource
	private LotteryTypeMapper mLotteryTypeMapper;
	@Resource
	LotteryClazzMapper mLotteryClazzMapper;

	public int updateById(LotteryClazz params) {
		return mLotteryClazzMapper.updateByPrimaryKeyWithBLOBs(params);
	}

	public int delectById(LotteryClazz params) {
		return mLotteryClazzMapper.deleteByPrimaryKey(params
				.getLotteryClazzId());
	}

	public int addClazz(LotteryClazz params) {
		return mLotteryClazzMapper.insertSelective(params);
	}

	public LotteryClazzTree findClazzByParentId() {
		LotteryClazzTree tree = new LotteryClazzTree();
			
		
		List<LotteryClazzTree> treeClazzList = mLotteryClazzMapper
				.selectByParentId(C.LotteryClazz.MAIN);
		tree.setClazzList(treeClazzList);
		LotteryClazzSearch search = new LotteryClazzSearch();
		search.setLotteryClazzId(C.LotteryClazz.MAIN);
		List<LotteryTypeWithBLOBs> typeList = mLotteryTypeMapper
				.selectByClazzTypeOrClazzId(search);
		tree.setTypeList(typeList);
		queryTreeChildren(treeClazzList);
		
		return tree;
	}
	
	/**
	 * 遍历数组
	 * @param treeClazzList
	 */
	private void queryTreeChildren(List<LotteryClazzTree> treeClazzList){
		for (LotteryClazzTree children : treeClazzList) {
			List<LotteryClazzTree> childList = mLotteryClazzMapper.selectByParentId(children.getLotteryClazzId());
			children.setClazzList(childList);
			queryTreeChildren(childList);
			
			LotteryClazzSearch search = new LotteryClazzSearch();
			search.setLotteryClazzId(children.getLotteryClazzId());
			List<LotteryTypeWithBLOBs> typeList = mLotteryTypeMapper
					.selectByClazzTypeOrClazzId(search);
			children.setTypeList(typeList);
		}
		
	}

}
