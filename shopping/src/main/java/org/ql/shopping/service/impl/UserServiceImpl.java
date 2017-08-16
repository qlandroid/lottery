package org.ql.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.IUserDao;
import org.ql.shopping.pojo.User;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	
	public List<User> queryUserOfAccount(String account) {
		User user = new User();
		user.setAccount(account);
		return userDao.queryUserOfAccount(user);
	}

	public long updateUserPassword(User user) {
		int rows = userDao.updateUserPassword(user);
		return rows;
	}

	
	public long inserteUser(User user) {
		int row = userDao.inserte(user);
		return row;
	}

	
	public List<User> queryUser(User user) {
		return userDao.queryUser(user);
	}


	public List<User> findAll(ListParams params) {
		int firstIndex = (params.getPage() -1 )* params.getPageSize();
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

	

}
