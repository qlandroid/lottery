package org.ql.shopping.dao;

import java.util.List;

import org.ql.shopping.pojo.User;
import org.ql.shopping.pojo.params.ListParams;

public interface IUserDao {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int inserte(User user);

	/**
	 * 通过账号和密码查询
	 * 
	 * @param user
	 * @return
	 */
	public List<User> queryUser(User user);

	/**
	 * 通过账号查询
	 * 
	 * @param account
	 * @return
	 */
	public List<User> queryUserOfAccount(User account);

	/**
	 * 更改密码
	 * 
	 * @param changePw
	 * @return
	 */
	public int updateUserPassword(User changePw);

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	public List<User> findAll(ListParams params);

	/**
	 * 查询用户数量
	 * @return
	 */
	public int queryTotalCount();

	/**
	 * 通过用户id删除用户
	 * @param id
	 * @return
	 */
	public long deletUserById(long id);
	
	public void deletAllUser();

}
