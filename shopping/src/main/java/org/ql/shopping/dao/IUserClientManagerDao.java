package org.ql.shopping.dao;

import java.util.List;

import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.UserManager;
import org.ql.shopping.pojo.params.UserClientManagerParams;

public interface IUserClientManagerDao {
	/**
	 * 添加用户
	 * @param um
	 * @return
	 */
	public int insterUserDetails(UserClientManagerParams params);
	
	public void insterUser(UserClientManagerParams params);
	
	/**
	 * 根据条件查询
	 * @param user
	 * @return
	 */
	public List<UserClient> findUser(UserClientManagerParams params);
	
	/**
	 * 根据条件查询
	 * @param user
	 * @return
	 */
	public List<UserClient> findUserLogin(UserClientManagerParams params);
	/**
	 * 分页查询
	 * @param user
	 * @return
	 */
	public void updateUserPw(UserClientManagerParams params);
	
	
	/**
	 * 根据用户id 更新用户信息
	 * @param user
	 * @return
	 */
	public void updateLBi(UserClientManagerParams params);
	/**
	 * 总条数
	 * @param queryUser 
	 * @return
	 */
	public long deleteUser(UserClientManagerParams params);
	
	public void deleteUserDetails(UserClientManagerParams params);

	public void updateUserDetails(UserClientManagerParams params);

	public Long getTotalCount(UserClientManagerParams params);
}
