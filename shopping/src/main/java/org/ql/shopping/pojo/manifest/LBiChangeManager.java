package org.ql.shopping.pojo.manifest;

import java.sql.Date;
import java.sql.Timestamp;

public class LBiChangeManager {
	// ?page=1&limit=30，
	private Long changeId;
	private String type;// 0-收入,1-支出
	private Long docExpendId;// 支出的
	private Long docIncomeId;// 收入的
	private Timestamp operateDate;// 操作的时间
	private Long userId;// 用户id
	private String account;// 用户账号

	private String remark;// 备注
	private String operateType;// 0-收入单创建，1-支出单创建，2-其他创建

	private Double payMoney;// 支付的金额
	private Double incomeInQty;
	private String incomeDocNo;

	private Double incomeBeforeQty;
	private Double incomeAfterQty;

	private Double expendOutQty;
	private Double expendBeforeQty;
	private Double expendAfterQty;
	private String expendDocNo;

	private Integer pageSize;
	private Long page;
	private Long firstIndex;
	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Timestamp getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Timestamp operateDate) {
		this.operateDate = operateDate;
	}

	public Long getChangeId() {
		return changeId;
	}

	public void setChangeId(Long changeId) {
		this.changeId = changeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getDocExpendId() {
		return docExpendId;
	}

	public void setDocExpendId(Long docExpendId) {
		this.docExpendId = docExpendId;
	}

	public Long getDocIncomeId() {
		return docIncomeId;
	}

	public void setDocIncomeId(Long docIncomeId) {
		this.docIncomeId = docIncomeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Double getIncomeInQty() {
		return incomeInQty;
	}

	public void setIncomeInQty(Double incomeInQty) {
		this.incomeInQty = incomeInQty;
	}

	public String getIncomeDocNo() {
		return incomeDocNo;
	}

	public void setIncomeDocNo(String incomeDocNo) {
		this.incomeDocNo = incomeDocNo;
	}

	public Double getIncomeBeforeQty() {
		return incomeBeforeQty;
	}

	public void setIncomeBeforeQty(Double incomeBeforeQty) {
		this.incomeBeforeQty = incomeBeforeQty;
	}

	public Double getIncomeAfterQty() {
		return incomeAfterQty;
	}

	public void setIncomeAfterQty(Double incomeAfterQty) {
		this.incomeAfterQty = incomeAfterQty;
	}

	public Double getExpendOutQty() {
		return expendOutQty;
	}

	public void setExpendOutQty(Double expendOutQty) {
		this.expendOutQty = expendOutQty;
	}

	public Double getExpendBeforeQty() {
		return expendBeforeQty;
	}

	public void setExpendBeforeQty(Double expendBeforeQty) {
		this.expendBeforeQty = expendBeforeQty;
	}

	public Double getExpendAfterQty() {
		return expendAfterQty;
	}

	public void setExpendAfterQty(Double expendAfterQty) {
		this.expendAfterQty = expendAfterQty;
	}

	public String getExpendDocNo() {
		return expendDocNo;
	}

	public void setExpendDocNo(String expendDocNo) {
		this.expendDocNo = expendDocNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(Long firstIndex) {
		this.firstIndex = firstIndex;
	}

}