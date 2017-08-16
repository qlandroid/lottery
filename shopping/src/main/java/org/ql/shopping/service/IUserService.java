package org.ql.shopping.service;

import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.ql.shopping.pojo.User;
import org.ql.shopping.pojo.params.ListParams;

public interface IUserService {
	List<User> queryUserOfAccount(String account) throws BindingException;
	long updateUserPassword(User user);
	long inserteUser(User user);
	List<User> queryUser(User user);
	List<User> findAll(ListParams params);
	long queryTotalCount();
	long deleteUser(long id);
	void deleteAllUser();
}
