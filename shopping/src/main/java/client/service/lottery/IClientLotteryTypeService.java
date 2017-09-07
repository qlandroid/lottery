package client.service.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryTypeSearch;

public interface IClientLotteryTypeService {

	List<LotteryTypeSearch> selectAll();

	Integer getAllCount();
}
