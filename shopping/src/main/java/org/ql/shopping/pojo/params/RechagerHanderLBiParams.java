package org.ql.shopping.pojo.params;

/**
 * 手动充值 参数
 * @author mrqiu
 *
 */
public class RechagerHanderLBiParams {
	
	private Long userId;//用户唯一id
	private Double payMoney;//支付的金额
	private Double inQty;//充值的积分
	private String zhifubaoDoc;//支付宝订单
	private String remark;//补充说明
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	public Double getInQty() {
		return inQty;
	}
	public void setInQty(Double inQty) {
		this.inQty = inQty;
	}
	public String getZhifubaoDoc() {
		return zhifubaoDoc;
	}
	public void setZhifubaoDoc(String zhifubaoDoc) {
		this.zhifubaoDoc = zhifubaoDoc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
