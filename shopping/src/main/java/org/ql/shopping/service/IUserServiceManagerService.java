package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.UserManager;

public interface IUserServiceManagerService {


	/**
	 * 添加用户，并返回当前用户的所有信息
	 * 
	 * @param user
	 * @return
	 */
	public UserManager inserteUser(UserManager user);

	public void updateUser(UserManager user);

	public void deleteAll();

	public void deleteUserById(Long id);

	public void deleteUser(UserManager user);

	public long getUserTotalCount(UserManager queryUser);

	/**
	 * 分页查询用户
	 * 
	 * @param page
	 * @return
	 */
	public List<UserManager> findPage(UserManager page);

	public UserManager findUserByAccount(String account);
	
	public UserManager findUserById(Long id);

}
