package org.ql.shopping.pojo.manifest;

import java.math.BigDecimal;

public class ManifestLBiChangeSearch extends ManifestLBiChange {
	private String phone;
	private String clientId;
	private String name;
	private String zhifubao;
	private String account;
	private String docNo;
	
	private String expendDocNo;
	private String incomeDocNo;
	
	private BigDecimal incomeQty;//收入金额
	private BigDecimal expendQty;//支出金额
	
	
	
	public BigDecimal getIncomeQty() {
		return incomeQty;
	}
	public void setIncomeQty(BigDecimal incomeQty) {
		this.incomeQty = incomeQty;
	}
	public BigDecimal getExpendQty() {
		return expendQty;
	}
	public void setExpendQty(BigDecimal expendQty) {
		this.expendQty = expendQty;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZhifubao() {
		return zhifubao;
	}
	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getExpendDocNo() {
		return expendDocNo;
	}
	public void setExpendDocNo(String expendDocNo) {
		this.expendDocNo = expendDocNo;
	}
	public String getIncomeDocNo() {
		return incomeDocNo;
	}
	public void setIncomeDocNo(String incomeDocNo) {
		this.incomeDocNo = incomeDocNo;
	}
	
	
}
