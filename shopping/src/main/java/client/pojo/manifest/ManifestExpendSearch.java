package client.pojo.manifest;

import java.util.Date;

import org.ql.shopping.pojo.manifest.ManifestExpend;

public class ManifestExpendSearch extends ManifestExpend{
	
	private Integer fillOpenId;//彩票的ID
	private Date fillCreateDate;//创建日期
	private Double fillLBi;//满足多少积分
	private Double awardLBi;//中奖金额
	private String fillName;//彩票名称
	private String lotteryStage;//彩票的唯一码
	private Double unit;//支付的基数
	private Double payMoney;//支付的总金额
	
	private Double overBuyQty;//已经购买该彩票的数量
	
	
	
	public Double getOverBuyQty() {
		return overBuyQty;
	}
	public void setOverBuyQty(Double overBuyQty) {
		this.overBuyQty = overBuyQty;
	}
	public Integer getFillOpenId() {
		return fillOpenId;
	}
	public void setFillOpenId(Integer fillOpenId) {
		this.fillOpenId = fillOpenId;
	}
	public Date getFillCreateDate() {
		return fillCreateDate;
	}
	public void setFillCreateDate(Date fillCreateDate) {
		this.fillCreateDate = fillCreateDate;
	}
	public Double getFillLBi() {
		return fillLBi;
	}
	public void setFillLBi(Double fillLBi) {
		this.fillLBi = fillLBi;
	}
	public Double getAwardLBi() {
		return awardLBi;
	}
	public void setAwardLBi(Double awardLBi) {
		this.awardLBi = awardLBi;
	}
	public String getFillName() {
		return fillName;
	}
	public void setFillName(String fillName) {
		this.fillName = fillName;
	}
	public String getLotteryStage() {
		return lotteryStage;
	}
	public void setLotteryStage(String lotteryStage) {
		this.lotteryStage = lotteryStage;
	}
	public Double getUnit() {
		return unit;
	}
	public void setUnit(Double unit) {
		this.unit = unit;
	}
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	
	
	
}
