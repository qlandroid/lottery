package org.ql.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.IUserManagerDao;
import org.ql.shopping.pojo.UserManager;
import org.ql.shopping.service.IUserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userManagerService")
public class UserManagerServiceImpl implements IUserManagerService{

	
	@Resource
	private IUserManagerDao mUserManagerDao;
	
	public UserManager findUserOfAccount(String account) {
		
		UserManager user = new  UserManager();
		user.setAccount(account);
		List<UserManager> list = mUserManagerDao.findUser(user);
		if(list == null || list.size() == 0){
			return null;
		}
		
		return list.get(0);
	}

	public UserManager inserteUser(UserManager user) {
		mUserManagerDao.inserte(user);
		UserManager accountUser = new UserManager();
		accountUser.setAccount(user.getAccount());
		List<UserManager> list = mUserManagerDao.findUser(accountUser);
		return list.get(0);
	}

	public void updateUser(UserManager user) {
		mUserManagerDao.updateUser(user);
	}

	public void deleteAll() {
		mUserManagerDao.deleteAll();
	}

	public List<UserManager> findPage(UserManager page) {
		return mUserManagerDao.findAll(page);
	}

	public long getUserTotalCount() {
		return mUserManagerDao.queryTotalCount();
	}

	public UserManager findUserByAccount(String account) {
		UserManager acc = new UserManager();
		acc.setAccount(account);
		List<UserManager> list = mUserManagerDao.findUser(acc);
		if(list == null || list.size() == 0){
			return null;
		}
		
		return list.get(0);
	}

}
