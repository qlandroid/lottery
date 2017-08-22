package org.ql.shopping.pojo.manifest;

import java.sql.Date;

public class Manifest {
	private long id;
	private Date createDate;//订单创建日期
	private Date endDate;//订单结束日期
	private String status;//订单状态
	private double price;//原价
	private double priceEnd;//用户支付金额；
	private long ownerId;//所属用户ID；
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPriceEnd() {
		return priceEnd;
	}
	public void setPriceEnd(double priceEnd) {
		this.priceEnd = priceEnd;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	
}
