package client.pojo.lottery;

import org.ql.shopping.pojo.lottery.LotteryFillOpen;

public class ClientLotteryFillOpenSearch extends LotteryFillOpen{
	
	
	/**
	 * 返回参数
	 */
	private String lotteryRemark; //彩票备注
	private Integer lotteryClzzId;//彩票的大类类型
	private String lotteryName;//彩票名称
	private String lotteryRule;//彩票规则
	private String lotteryType;// 彩票类型
	private Integer buyQty; //已经购买数量
	
	
	public String getLotteryRemark() {
		return lotteryRemark;
	}
	public void setLotteryRemark(String lotteryRemark) {
		this.lotteryRemark = lotteryRemark;
	}
	public Integer getLotteryClzzId() {
		return lotteryClzzId;
	}
	public void setLotteryClzzId(Integer lotteryClzzId) {
		this.lotteryClzzId = lotteryClzzId;
	}
	public String getLotteryName() {
		return lotteryName;
	}
	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}
	public String getLotteryRule() {
		return lotteryRule;
	}
	public void setLotteryRule(String lotteryRule) {
		this.lotteryRule = lotteryRule;
	}
	public String getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(String lotteryType) {
		this.lotteryType = lotteryType;
	}
	public Integer getBuyQty() {
		return buyQty;
	}
	public void setBuyQty(Integer buyQty) {
		this.buyQty = buyQty;
	}
	
	
}
