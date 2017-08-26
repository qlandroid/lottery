package org.ql.shopping.pojo.manifest;

import java.math.BigDecimal;
import java.util.Date;

import org.ql.shopping.pojo.Model;

public class ManifestIncome extends Model {
	private Integer incomeId;

	private Date incomeCreateDate;

	private String zhifubaoDoc;

	private BigDecimal payMoney;

	private BigDecimal incomeInQty;

	private String incomeDocNo;

	private String status;// '当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单'

	private Integer userId;

	private BigDecimal incomeBeforeQty;

	private BigDecimal incomeAfterQty;

	private Date incomeEndDate;

	public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

	public Date getIncomeCreateDate() {
		return incomeCreateDate;
	}

	public void setIncomeCreateDate(Date incomeCreateDate) {
		this.incomeCreateDate = incomeCreateDate;
	}

	public String getZhifubaoDoc() {
		return zhifubaoDoc;
	}

	public void setZhifubaoDoc(String zhifubaoDoc) {
		this.zhifubaoDoc = zhifubaoDoc == null ? null : zhifubaoDoc.trim();
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public BigDecimal getIncomeInQty() {
		return incomeInQty;
	}

	public void setIncomeInQty(BigDecimal incomeInQty) {
		this.incomeInQty = incomeInQty;
	}

	public String getIncomeDocNo() {
		return incomeDocNo;
	}

	public void setIncomeDocNo(String incomeDocNo) {
		this.incomeDocNo = incomeDocNo == null ? null : incomeDocNo.trim();
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

	public BigDecimal getIncomeBeforeQty() {
		return incomeBeforeQty;
	}

	public void setIncomeBeforeQty(BigDecimal incomeBeforeQty) {
		this.incomeBeforeQty = incomeBeforeQty;
	}

	public BigDecimal getIncomeAfterQty() {
		return incomeAfterQty;
	}

	public void setIncomeAfterQty(BigDecimal incomeAfterQty) {
		this.incomeAfterQty = incomeAfterQty;
	}

	public Date getIncomeEndDate() {
		return incomeEndDate;
	}

	public void setIncomeEndDate(Date incomeEndDate) {
		this.incomeEndDate = incomeEndDate;
	}
}