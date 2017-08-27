package org.ql.shopping.pojo.lottery;

import org.ql.shopping.pojo.Model;

public class LotteryType extends Model {
	private Integer lotteryTypeId;

	private String lotteryType;

	private String lotteryName;

	private Integer lotteryClazzId;

	public Integer getLotteryTypeId() {
		return lotteryTypeId;
	}

	public void setLotteryTypeId(Integer lotteryTypeId) {
		this.lotteryTypeId = lotteryTypeId;
	}

	public String getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(String lotteryType) {
		this.lotteryType = lotteryType == null ? null : lotteryType.trim();
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName == null ? null : lotteryName.trim();
	}
	public Integer getLotteryClazzId() {
		return lotteryClazzId;
	}

	public void setLotteryClazzId(Integer lotteryClazzId) {
		this.lotteryClazzId = lotteryClazzId;
	}
}