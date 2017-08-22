package org.ql.shopping.service.user;

import java.util.List;

import org.apache.ibatis.binding.BindingException;
import org.ql.shopping.pojo.params.ListParams;
import org.ql.shopping.pojo.user.UserLogin;

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
