package org.ql.shopping.pojo;

import java.sql.Date;

/**
 * 双色球
 * @author mrqiu
 *
 */
public class LotterySSQ {
	private long id;
	private long ownerId;
	private String number;
	private Date createTime;
	private int quantity;
	private long manifestId;
	private Date openLottery;
	
	
	public Date getOpenLottery() {
		return openLottery;
	}
	public void setOpenLottery(Date openLottery) {
		this.openLottery = openLottery;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getManifestId() {
		return manifestId;
	}
	public void setManifestId(long manifestId) {
		this.manifestId = manifestId;
	}
	
	
	
}
