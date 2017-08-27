package org.ql.shopping.pojo.lottery;

import org.ql.shopping.pojo.Model;

public class LotteryFillUser extends Model {
	private Integer lotteryFillUserId;

	private Integer lotteryTypeId;

	private Integer userId;

	private Integer lotteryFillOpenId;

	private String number;

	private Integer lotteryFillBuyQty;

	private String lotteryFillStatus;

	public Integer getLotteryFillUserId() {
		return lotteryFillUserId;
	}

	public void setLotteryFillUserId(Integer lotteryFillUserId) {
		this.lotteryFillUserId = lotteryFillUserId;
	}

	public Integer getLotteryTypeId() {
		return lotteryTypeId;
	}

	public void setLotteryTypeId(Integer lotteryTypeId) {
		this.lotteryTypeId = lotteryTypeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLotteryFillOpenId() {
		return lotteryFillOpenId;
	}

	public void setLotteryFillOpenId(Integer lotteryFillOpenId) {
		this.lotteryFillOpenId = lotteryFillOpenId;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Integer getLotteryFilldBuyQty() {
		return lotteryFillBuyQty;
	}

	public void setLotteryFilldBuyQty(Integer lotteryFillBuyQty) {
		this.lotteryFillBuyQty = lotteryFillBuyQty;
	}

	public String getLotteryFillStatus() {
		return lotteryFillStatus;
	}

	public void setLotteryFillStatus(String lotteryFillStatus) {
		this.lotteryFillStatus = lotteryFillStatus == null ? null : lotteryFillStatus.trim();
	}
}