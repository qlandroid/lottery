package org.ql.shopping.pojo.result;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.lottery.LotteryTypeWithBLOBs;

public class LotteryClazzTree extends LotteryClazz {

	private List<LotteryClazzTree> clazzList;// 当前打来下所有的子大类
	private List<LotteryTypeWithBLOBs> typeList;// 当前大类下的所有彩票类型

	public List<LotteryClazzTree> getClazzList() {
		return clazzList;
	}

	public void setClazzList(List<LotteryClazzTree> clazzList) {
		this.clazzList = clazzList;
	}

	public List<LotteryTypeWithBLOBs> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<LotteryTypeWithBLOBs> typeList) {
		this.typeList = typeList;
	}
}
