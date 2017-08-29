package org.ql.shopping.pojo.manifest;

import java.math.BigDecimal;
import java.util.Date;

import org.ql.shopping.pojo.Model;

public class ManifestExpend extends Model {
	private Integer expendId;

	private String docNo;

	private Date createTime;

	private BigDecimal expendQty;

	private String status;

	private Integer userId;

	private Date endTime;

	private BigDecimal afterQty;

	private BigDecimal beforeQty;

	private Integer lotteryTypeId;//彩票类型的id
	
	private Integer lotteryId;//彩票的id
	
	

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}

	public Integer getExpendId() {
		return expendId;
	}

	public void setExpendId(Integer expendId) {
		this.expendId = expendId;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo == null ? null : docNo.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getExpendQty() {
		return expendQty;
	}

	public void setExpendQty(BigDecimal expendQty) {
		this.expendQty = expendQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getAfterQty() {
		return afterQty;
	}

	public void setAfterQty(BigDecimal afterQty) {
		this.afterQty = afterQty;
	}

	public BigDecimal getBeforeQty() {
		return beforeQty;
	}

	public void setBeforeQty(BigDecimal beforeQty) {
		this.beforeQty = beforeQty;
	}

	public Integer getLotteryTypeId() {
		return lotteryTypeId;
	}

	public void setLotteryTypeId(Integer lotteryTypeId) {
		this.lotteryTypeId = lotteryTypeId;
	}
}