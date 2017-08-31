package client.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.user.IUserDao;
import org.springframework.stereotype.Service;

import client.pojo.user.UserLoginSearch;
import client.service.user.IUserManagerService;

@Service("userManagerService")
public class UserManagerService implements IUserManagerService {

	@Resource
	private IUserDao mUserLoginDao;

	public int insert(UserLoginSearch params) {
		return mUserLoginDao.inserte(params);
	}

	public int updatePw(UserLoginSearch params) {
		return mUserLoginDao.updateUserPassword(params);
	}

	public UserLoginSearch selectByAccount(String account) {
		UserLoginSearch params =new UserLoginSearch();
		params.setAccount(account);
		List<UserLoginSearch> selectUserByParams = mUserLoginDao.selectUserByParams(params);
		if(selectUserByParams == null || selectUserByParams.size() <= 0){
			return null;
		}
		return selectUserByParams.get(0);
	}

	public UserLoginSearch selectyByAccountAndPw(String account, String pw) {
		UserLoginSearch params =new UserLoginSearch();
		params.setAccount(account);
		params.setPw(pw);
		List<UserLoginSearch> selectUserByParams = mUserLoginDao.selectUserByParams(params);
		if(selectUserByParams == null || selectUserByParams.size() <= 0){
			return null;
		}
		return selectUserByParams.get(0);
	}

}
