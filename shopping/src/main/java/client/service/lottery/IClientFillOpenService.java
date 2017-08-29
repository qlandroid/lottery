package client.service.lottery;

import client.pojo.fill.FillOpenSearch;

public interface IClientFillOpenService {
	
	FillOpenSearch selectDetailsByOpenId(Integer openId);
}
