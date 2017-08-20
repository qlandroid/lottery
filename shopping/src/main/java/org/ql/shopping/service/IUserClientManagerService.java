package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.params.UserClientManagerParams;

public interface IUserClientManagerService {

	/**
	 * 添加用户，并添加用户详情
	 * @param params
	 */
	public void inserte(UserClientManagerParams params);
	
	/**
	 * 通过用户的参数进行删除用户
	 * @param params
	 */
	public void deleteUser(UserClientManagerParams params); 
	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<UserClient> findUser(UserClientManagerParams params);
	
	public UserClient findUserById(Long id);
	
	public void updateUser(UserClientManagerParams params);

	public Long getTotalCount(UserClientManagerParams params);

	public UserClient findUserByAccount(String account);
	
	
}
