package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.UserManager;

public interface IUserManagerService {

	/**
	 * 通过账号查询，用户
	 * @param account
	 * @return
	 */
	public UserManager findUserOfAccount(String account);
	
	
	/**
	 * 添加用户，并返回当前用户的所有信息
	 * @param user
	 * @return
	 */
	public UserManager inserteUser(UserManager user);
	
	public void updateUser(UserManager user);
	
	public void deleteAll();
	
	public long getUserTotalCount();
	
	/**
	 * 分页查询用户
	 * @param page
	 * @return
	 */
	public List<UserManager> findPage(UserManager page);
	

}
