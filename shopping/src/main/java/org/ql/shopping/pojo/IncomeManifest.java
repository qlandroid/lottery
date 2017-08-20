package org.ql.shopping.pojo;

import java.sql.Date;

public class IncomeManifest {

	private Long incomeId;//任务单Id;
	
	private Long userId;//所属用户id
	private String name;
	private String account;
	private Date createDate;//充值日期
	
	private Double inQty;//充值数量
	private Double beforeQty;//之前的积分数量；
	private Double afterQty;//充值之后的积分数量；
	private Double payMoney;//充值金额；
	
	private String status;//订单状态；当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单

	
	private String zhifubaoDoc;//支付宝的订单
	private Long page;
	private Integer pageSize;
	private Long total;
	private Long pageTotal;
	private Long firstIndex;
	
	private String incomeDocNo;
	
	private Date endDate;
	private double lBi;
	
	private String zhifubao;//用户的支付宝账号
	
	
	
	
	public Long getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}
	public String getZhifubao() {
		return zhifubao;
	}
	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}
	public double getlBi() {
		return lBi;
	}
	public void setlBi(double lBi) {
		this.lBi = lBi;
	}
	public String getIncomeDocNo() {
		return incomeDocNo;
	}
	public void setIncomeDocNo(String incomeDocNo) {
		this.incomeDocNo = incomeDocNo;
	}
	public Long getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(Long firstIndex) {
		this.firstIndex = firstIndex;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Long pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

	public String getZhifubaoDoc() {
		return zhifubaoDoc;
	}

	public void setZhifubaoDoc(String zhifubaoDoc) {
		this.zhifubaoDoc = zhifubaoDoc;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getInQty() {
		return inQty;
	}

	public void setInQty(Double inQty) {
		this.inQty = inQty;
	}

	public Double getBeforeQty() {
		return beforeQty;
	}

	public void setBeforeQty(Double beforeQty) {
		this.beforeQty = beforeQty;
	}

	public Double getAfterQty() {
		return afterQty;
	}

	public void setAfterQty(Double afterQty) {
		this.afterQty = afterQty;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
