package org.ql.shopping.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.user.IUserDao;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.pojo.user.UserLogin;
import org.ql.shopping.service.user.IUserLoginService;
import org.springframework.stereotype.Service;

@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLoginService {

	@Resource
	private IUserDao userDao;

	public List<UserLogin> queryUserOfAccount(String account) {
		UserLogin user = new UserLogin();
		user.setAccount(account);
		return userDao.queryUserOfAccount(user);
	}

	public long updateUserPassword(UserLogin user) {
		int rows = userDao.updateUserPassword(user);
		return rows;
	}

	public long inserteUser(UserLogin user) {
		int row = userDao.inserte(user);
		return row;
	}

	public List<UserLogin> queryUser(UserLogin user) {
		return userDao.queryUser(user);
	}

	public List<UserLogin> findAll(ListParams params) {
		int firstIndex = (params.getPage() - 1) * params.getPageSize();
		int footIndex = params.getPage() * params.getPageSize();
		params.setFirstIndex(firstIndex);
		params.setFootIndex(footIndex);

		return userDao.findAll(params);
	}

	public long queryTotalCount() {
		return userDao.queryTotalCount();
	}

	public long deleteUser(long id) {
		return userDao.deletUserById(id);
	}

	public void deleteAllUser() {
		userDao.deletAllUser();

	}

}
