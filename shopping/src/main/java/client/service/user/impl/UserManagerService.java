package client.service.user.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.user.UserClientMapper;
import org.springframework.stereotype.Service;

import client.pojo.user.UserClientSearch;
import client.service.user.IUserManagerService;

@Service("userManagerService")
public class UserManagerService implements IUserManagerService {

	@Resource 
	private UserClientMapper mUserClientMapper;


	public UserClientSearch selectPayPwByUserId(Integer userId) {
		return mUserClientMapper.selectPayPwByUserId(userId);
	}

	public UserClientSearch selectDetailsByUserId(Integer userId) {
		
		return mUserClientMapper.selectDetailsByUserId(userId);
	}

	public void insert(UserClientSearch params) {
		//注册用户
		mUserClientMapper.insertLogin(params);
		mUserClientMapper.insertSelective(params);
	}

	public int updatePwByUserId(UserClientSearch params) {
		return mUserClientMapper.updatePwByUserId(params);
	}

	public UserClientSearch selectByAccount(String account) {
		return mUserClientMapper.selectDetailsByAccount(account);
	}

	public UserClientSearch selectyByAccountAndPw(String account, String pw) {
		UserClientSearch params = new UserClientSearch();
		params.setAccount(account);
		params.setPw(pw);
		return mUserClientMapper.selectDetailsByAccountAndPw(params);
	}

}
