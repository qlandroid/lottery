package org.ql.shopping.service.user;

import java.util.List;

import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.pojo.user.UserClientSSearch;

public interface IUserClientManagerService {

	/**
	 * 添加用户，并添加用户详情
	 * 
	 * @param params
	 */
	public void inserte(UserClientSSearch params);

	/**
	 * 通过用户的参数进行删除用户
	 * 
	 * @param params
	 */
	public void deleteUser(UserClientSSearch params);

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	public List<UserClientSSearch> findUser(UserClientSSearch params);

	public UserClientSSearch findUserByUserId(Integer id);

	public void updateUser(UserClientSSearch params);

	public Integer getListCountByParams(UserClientSSearch params);

	public UserClientSSearch findUserByAccount(String account);
	
	public void updateLBi(Double lbi,Integer id);

}
