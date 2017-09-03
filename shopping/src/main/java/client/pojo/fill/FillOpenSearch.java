package client.pojo.fill;

import java.math.BigDecimal;

import org.ql.shopping.pojo.lottery.LotteryFillOpen;

public class FillOpenSearch extends LotteryFillOpen{
	private BigDecimal totalQty;//总是数量
	private BigDecimal overBuyQty;//已经购买数量
	private BigDecimal userBuyQty;//用户购买的数量；
	
	
	
	public BigDecimal getUserBuyQty() {
		return userBuyQty;
	}
	public void setUserBuyQty(BigDecimal userBuyQty) {
		this.userBuyQty = userBuyQty;
	}
	public BigDecimal getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(BigDecimal totalQty) {
		this.totalQty = totalQty;
	}
	public BigDecimal getOverBuyQty() {
		return overBuyQty;
	}
	public void setOverBuyQty(BigDecimal overBuyQty) {
		this.overBuyQty = overBuyQty;
	}
	

	
	

}
