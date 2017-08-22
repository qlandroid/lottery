package org.ql.shopping.dao.user;

import java.util.List;

import org.ql.shopping.pojo.user.UserClient;

public interface IUserClientDao {
	public List<UserClient> find(UserClient client);
	
	public int update(UserClient client);
	
	public int changeLBi(UserClient client);
	
	public int addUser(UserClient client);
	
	public int deleteUser(long id);
}
