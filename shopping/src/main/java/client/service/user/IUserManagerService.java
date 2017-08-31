package client.service.user;

import client.pojo.user.UserLoginSearch;

public interface IUserManagerService {

	int insert(UserLoginSearch params);

	int updatePw(UserLoginSearch params);

	UserLoginSearch selectByAccount(String account);

	UserLoginSearch selectyByAccountAndPw(String account, String pw);
}
