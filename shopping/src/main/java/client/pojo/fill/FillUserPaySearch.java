package client.pojo.fill;

import org.ql.shopping.pojo.lottery.LotteryFillUser;

public class FillUserPaySearch extends LotteryFillUser{
	private Integer fillId;//当前彩票的id
	private Double payQty;//所要支付积分的数量
	
	private String expendDocNo;//支出任务单号
	private String payPw;//支付密码
	
	
	
	
	public String getPayPw() {
		return payPw;
	}
	public void setPayPw(String payPw) {
		this.payPw = payPw;
	}
	public String getExpendDocNo() {
		return expendDocNo;
	}
	public void setExpendDocNo(String expendDocNo) {
		this.expendDocNo = expendDocNo;
	}
	public Integer getFillId() {
		return fillId;
	}
	public void setFillId(Integer fillId) {
		this.fillId = fillId;
	}
	public Double getPayQty() {
		return payQty;
	}
	public void setPayQty(Double payQty) {
		this.payQty = payQty;
	}
	
	
	
	
	

}
