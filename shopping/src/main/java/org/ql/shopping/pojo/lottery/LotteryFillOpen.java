package org.ql.shopping.pojo.lottery;

import java.math.BigDecimal;
import java.util.Date;

public class LotteryFillOpen {
	private Integer lotteryFillOpenId;// 彩票的唯一id

	private String openNumber;// 开奖id

	private Date lotteryFillCreaterDate;// 创建彩票日期

	private Date lotteryFillEndDate;// 彩票结束日期，

	private Integer createUserId;// 创建彩票人的id

	private BigDecimal fillLBi;// 满多少积分

	private BigDecimal awardLBi;// 中奖积分数量

	private String sendStatus;// 是否发放奖金

	private BigDecimal lotteryFillUnitPrice;// 积分最低倍率，5 * unit

	private Integer lotteryTypeId;// 所属彩票类型的 id;

	public Integer getLotteryFillOpenId() {
		return lotteryFillOpenId;
	}

	public void setLotteryFillOpenId(Integer lotteryFillOpenId) {
		this.lotteryFillOpenId = lotteryFillOpenId;
	}

	public String getOpenNumber() {
		return openNumber;
	}

	public void setOpenNumber(String openNumber) {
		this.openNumber = openNumber == null ? null : openNumber.trim();
	}

	public Date getLotteryFillCreaterDate() {
		return lotteryFillCreaterDate;
	}

	public void setLotteryFillCreaterDate(Date lotteryFillCreaterDate) {
		this.lotteryFillCreaterDate = lotteryFillCreaterDate;
	}

	public Date getLotteryFillEndDate() {
		return lotteryFillEndDate;
	}

	public void setLotteryFillEndDate(Date lotteryFillEndDate) {
		this.lotteryFillEndDate = lotteryFillEndDate;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public BigDecimal getFillLBi() {
		return fillLBi;
	}

	public void setFillLBi(BigDecimal fillLBi) {
		this.fillLBi = fillLBi;
	}

	public BigDecimal getAwardLBi() {
		return awardLBi;
	}

	public void setAwardLBi(BigDecimal awardLBi) {
		this.awardLBi = awardLBi;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus == null ? null : sendStatus.trim();
	}

	public BigDecimal getLotteryFillUnitPrice() {
		return lotteryFillUnitPrice;
	}

	public void setLotteryFillUnitPrice(BigDecimal lotteryFillUnitPrice) {
		this.lotteryFillUnitPrice = lotteryFillUnitPrice;
	}

	public Integer getLotteryTypeId() {
		return lotteryTypeId;
	}

	public void setLotteryTypeId(Integer lotteryTypeId) {
		this.lotteryTypeId = lotteryTypeId;
	}
}