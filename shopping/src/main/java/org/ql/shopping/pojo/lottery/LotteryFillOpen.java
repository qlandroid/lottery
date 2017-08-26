package org.ql.shopping.pojo.lottery;

import java.math.BigDecimal;
import java.util.Date;

public class LotteryFillOpen {
	private Integer lotteryFillOpenId;//主键

	private String openNumber;//中奖 号码

	private Date lotteryFillCreaterDate;//创建日期

	private Date lotteryFillEndDate;//结束日期

	private Integer createUserId;//创建人id

	private BigDecimal fillLBi;//满多少积分进行抽奖

	private BigDecimal awardLBi;//中奖奖金金额

	private String sendStatus;//是否发放奖金	

	private BigDecimal lotteryFillUnitPrice;//购买单价

	private Integer lotteryTypeId;//所属typeid

	private String lotteryFillName;//彩票名称

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

	public String getLotteryFillName() {
		return lotteryFillName;
	}

	public void setLotteryFillName(String lotteryFillName) {
		this.lotteryFillName = lotteryFillName == null ? null : lotteryFillName.trim();
	}
}