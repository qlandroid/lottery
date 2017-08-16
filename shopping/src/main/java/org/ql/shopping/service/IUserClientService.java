package org.ql.shopping.service;

import java.util.List;

import org.ql.shopping.pojo.UserClient;

public interface IUserClientService {

	public int addUserClient(UserClient user);
	
	public List<UserClient> findUserClient(UserClient userClient);
	
	public int updateUserClient(UserClient userClient);
	
	public long deleteUser(long id);
	
}
