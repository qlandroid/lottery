package org.ql.shopping.dao.user;

import java.util.List;

import org.ql.shopping.pojo.user.UserManager;

public interface IUserManagerDao {
	
	/**
	 * 添加用户
	 * @param um
	 * @return
	 */
	public int inserte(UserManager um);
	
	
	/**
	 * 根据条件查询
	 * @param user
	 * @return
	 */
	public List<UserManager> findUser(UserManager user);
	/**
	 * 分页查询
	 * @param user
	 * @return
	 */
	public List<UserManager> findAll(UserManager user);
	
	
	/**
	 * 根据用户id 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(UserManager user);
	/**
	 * 总条数
	 * @param queryUser 
	 * @return
	 */
	public long queryTotalCount(UserManager queryUser);

	
	/**
	 * 根据条件进行删除
	 * @param user
	 * @return
	 */
	public int deleteUser(UserManager user);
	
	
	
	/**
	 * 删除所有用户
	 */
	public void deleteAll();
	
}
