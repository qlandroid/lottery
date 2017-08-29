package client.pojo.fill;

import java.math.BigDecimal;

import org.ql.shopping.pojo.lottery.LotteryFillOpen;

public class FillOpenSearch extends LotteryFillOpen{
	private BigDecimal totalQty;//总是数量
	private BigDecimal overBuyQty;//已经购买数量
	
	
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
