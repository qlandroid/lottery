package org.ql.shopping.service.user.impl;

import javax.annotation.Resource;

import org.ql.shopping.dao.user.UserClientMapper;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.service.user.IUserClientService;
import org.springframework.stereotype.Service;

@Service("userClientService")
public class UserClientServiceImpl implements IUserClientService {

	@Resource
	private UserClientMapper mUserClientDao;

	public int addUserClient(UserClient user) {
		return mUserClientDao.insertSelective(user);
	}

	public UserClient findUserClientByUserId(Integer userClient) {
		return mUserClientDao.selectDetailsByUserId(userClient);
	}

	public int updateUserClient(UserClient userClient) {
		return mUserClientDao.updateByPrimaryKeySelective(userClient);
	}

	public Integer deleteUser(Integer id) {
		return mUserClientDao.deleteByPrimaryKey(id);
	}

}
