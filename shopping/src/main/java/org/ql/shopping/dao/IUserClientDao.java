package org.ql.shopping.dao;

import java.util.List;

import org.ql.shopping.pojo.UserClient;

public interface IUserClientDao {
	public List<UserClient> find(UserClient client);
	
	public int update(UserClient client);
	
	public int changeLBi(UserClient client);
	
	public int addUser(UserClient client);
	
	public int deleteUser(long id);
}
