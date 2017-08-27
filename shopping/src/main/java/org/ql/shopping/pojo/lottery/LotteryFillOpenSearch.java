package org.ql.shopping.pojo.lottery;

public class LotteryFillOpenSearch extends LotteryFillOpen {
	public String createUserName;//创建人
	public Integer limit;
	public Integer overBuyQty;

	public Integer getOverBuyQty() {
		return overBuyQty;
	}

	public void setOverBuyQty(Integer overBuyQty) {
		this.overBuyQty = overBuyQty;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	
}
