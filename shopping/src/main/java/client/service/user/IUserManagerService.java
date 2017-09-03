package client.service.user;

import client.pojo.user.UserClientSearch;
import client.pojo.user.UserLoginSearch;

public interface IUserManagerService {

	void  insert(UserClientSearch params);

	int updatePwByUserId(UserClientSearch params);

	UserClientSearch selectByAccount(String account);

	UserClientSearch selectyByAccountAndPw(String account, String pw);

	UserClientSearch selectPayPwByUserId(Integer userId);
	
	UserClientSearch selectDetailsByUserId(Integer userId);
}
