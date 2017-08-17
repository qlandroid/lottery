package org.ql.shopping.service;

import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.ql.shopping.pojo.UserLogin;
import org.ql.shopping.pojo.params.ListParams;

public interface IUserLoginService {
	List<UserLogin> queryUserOfAccount(String account) throws BindingException;
	long updateUserPassword(UserLogin user);
	long inserteUser(UserLogin user);
	List<UserLogin> queryUser(UserLogin user);
	List<UserLogin> findAll(ListParams params);
	long queryTotalCount();
	long deleteUser(long id);
	void deleteAllUser();
}
