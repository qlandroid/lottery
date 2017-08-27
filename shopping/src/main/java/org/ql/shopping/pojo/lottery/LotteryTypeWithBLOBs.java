package org.ql.shopping.pojo.lottery;

public class LotteryTypeWithBLOBs extends LotteryType {
	private String lotteryRule;

	private String lotteryRemark;

	public String getLotteryRule() {
		return lotteryRule;
	}

	public void setLotteryRule(String lotteryRule) {
		this.lotteryRule = lotteryRule == null ? null : lotteryRule.trim();
	}

	public String getLotteryRemark() {
		return lotteryRemark;
	}

	public void setLotteryRemark(String lotteryRemark) {
		this.lotteryRemark = lotteryRemark == null ? null : lotteryRemark.trim();
	}
}