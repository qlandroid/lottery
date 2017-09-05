package org.ql.shopping.pojo.lottery;

public class LotteryFillOpenSearch extends LotteryFillOpen {
	public static final String TPYE_CAN_SEND = "1";//满足开奖条件
	public static final String TYPE_NOT_SEND = "0";//不满足开奖条件
	
	private Integer id;//open彩票的唯一id
	private String createUserName;//创建人
	private Integer limit;
	private Integer overBuyQty;
	private String canSendAward;//0-未满足开奖条件，1-满足开奖条件
	private Integer createUserId;//创建人id
	private String createAccount;//创建人账号
	
	
	
	
	public String getCreateAccount() {
		return createAccount;
	}

	public void setCreateAccount(String createAccount) {
		this.createAccount = createAccount;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCanSendAward() {
		return canSendAward;
	}

	public void setCanSendAward(String canSendAward) {
		this.canSendAward = canSendAward;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
