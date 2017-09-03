package org.ql.shopping.pojo.lottery;

import java.math.BigDecimal;
import java.util.Date;

public class FillUserDetails extends LotteryFillUser{
	private String zhifubao;
	private String name;
	private String clientId;
	private String phone;
	private Integer userId;
	private BigDecimal lBi;
	private String account;
	
	//所在订单内容
	private String docNo;
	private Date createTime;
	private BigDecimal afterQty;
	private BigDecimal beforeQty;
	private BigDecimal expendQty;
	
	
	
	
	
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public BigDecimal getExpendQty() {
		return expendQty;
	}
	public void setExpendQty(BigDecimal expendQty) {
		this.expendQty = expendQty;
	}
	public String getZhifubao() {
		return zhifubao;
	}
	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public BigDecimal getlBi() {
		return lBi;
	}
	public void setlBi(BigDecimal lBi) {
		this.lBi = lBi;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	
}
