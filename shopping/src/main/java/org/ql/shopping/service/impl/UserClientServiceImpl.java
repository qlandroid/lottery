package org.ql.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.IUserClientDao;
import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.UserManager;
import org.ql.shopping.service.IUserClientService;
import org.springframework.stereotype.Service;
@Service("userClientService")
public class UserClientServiceImpl implements IUserClientService{

	@Resource
	private IUserClientDao mUserClientDao;
	
	public int addUserClient(UserClient user) {
		return mUserClientDao.addUser(user);
	}

	public List<UserClient> findUserClient(UserClient userClient) {
		return mUserClientDao.find(userClient);
	}

	public int updateUserClient(UserClient userClient) {
		return mUserClientDao.update(userClient);
	}

	public long deleteUser(long id) {
		return mUserClientDao.deleteUser(id);
	}



}
