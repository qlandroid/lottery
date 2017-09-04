package org.ql.shopping.service.user;

import org.ql.shopping.pojo.user.UserClient;

public interface IUserClientService {

	public int addUserClient(UserClient user);

	public UserClient findUserClientByUserId(Integer id);

	public int updateUserClient(UserClient userClient);

	public Integer deleteUser(Integer id);

}
