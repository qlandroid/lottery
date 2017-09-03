package org.ql.shopping.dao.user;

import org.apache.ibatis.annotations.Param;
import org.ql.shopping.pojo.user.UserClient;

import client.pojo.user.UserClientSearch;

public interface UserClientMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserClient record);

	int insertSelective(UserClient record);

	UserClient selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserClient record);

	int updateByPrimaryKey(UserClient record);

	UserClientSearch selectPayPwByUserId(@Param("userId") Integer userId);

	UserClientSearch selectDetailsByUserId(@Param("userId") Integer userId);

	void insertLogin(UserClientSearch params);

	int updatePwByUserId(UserClientSearch params);

	int updatePayPwByUserId(UserClientSearch params);

	UserClientSearch selectDetailsByAccount(@Param("account") String account);

	UserClientSearch selectDetailsByAccountAndPw(UserClientSearch params);
}