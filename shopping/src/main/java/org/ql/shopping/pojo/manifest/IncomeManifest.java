package org.ql.shopping.pojo.manifest;

import java.sql.Timestamp;

import org.ql.shopping.pojo.Model;

public class IncomeManifest extends Model{

	private Integer incomeId;// 任务单Id;

	private Integer userId;// 所属用户id
	private String name;
	private String account;
	private Timestamp createDate;// 充值日期

	private Double inQty;// 充值数量
	private Double beforeQty;// 之前的积分数量；
	private Double afterQty;// 充值之后的积分数量；
	private Double payMoney;// 充值金额；

	private String status;// 订单状态；当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单

	private String zhifubaoDoc;// 支付宝的订单

	private String incomeDocNo;// 当前任务单的单据号

	private Timestamp endDate;// 任务单结束时间
	private double lBi;// 用户的当前积分

	private String zhifubao;// 用户的支付宝账号

	private Double totalIncomeInQty;// 总充值积分
	private Double totalPayMoney;// 总支付金额

	private Double totalSelectInQty;// 筛选后的总充值积分
	private Double totalSelectPayMoney;// 筛选后的总支付金额

	public Double getTotalIncomeInQty() {
		return totalIncomeInQty;
	}

	public void setTotalIncomeInQty(Double totalIncomeInQty) {
		this.totalIncomeInQty = totalIncomeInQty;
	}

	public Double getTotalPayMoney() {
		return totalPayMoney;
	}

	public void setTotalPayMoney(Double totalPayMoney) {
		this.totalPayMoney = totalPayMoney;
	}

	public Double getTotalSelectInQty() {
		return totalSelectInQty;
	}

	public void setTotalSelectInQty(Double totalSelectInQty) {
		this.totalSelectInQty = totalSelectInQty;
	}

	public Double getTotalSelectPayMoney() {
		return totalSelectPayMoney;
	}

	public void setTotalSelectPayMoney(Double totalSelectPayMoney) {
		this.totalSelectPayMoney = totalSelectPayMoney;
	}

	public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
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

	public String getZhifubaoDoc() {
		return zhifubaoDoc;
	}

	public void setZhifubaoDoc(String zhifubaoDoc) {
		this.zhifubaoDoc = zhifubaoDoc;
	}


	public String getIncomeDocNo() {
		return incomeDocNo;
	}

	public void setIncomeDocNo(String incomeDocNo) {
		this.incomeDocNo = incomeDocNo;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public double getlBi() {
		return lBi;
	}

	public void setlBi(double lBi) {
		this.lBi = lBi;
	}

	public String getZhifubao() {
		return zhifubao;
	}

	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}

}
