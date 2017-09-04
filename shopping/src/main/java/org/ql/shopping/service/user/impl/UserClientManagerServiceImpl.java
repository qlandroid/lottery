package org.ql.shopping.service.user.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.user.IUserClientManagerDao;
import org.ql.shopping.dao.user.UserClientMapper;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.pojo.user.UserClientSSearch;
import org.ql.shopping.pojo.user.UserLogin;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.service.user.IUserLoginService;
import org.ql.shopping.util.ModelUtils;
import org.ql.shopping.util.NumberUtils;
import org.ql.shopping.util.StringUtils;
import org.springframework.stereotype.Service;

import client.pojo.user.UserClientSearch;

@Service("userClientMangaerService")
public class UserClientManagerServiceImpl implements IUserClientManagerService {

	@Resource
	private UserClientMapper mUserClientMapper;
	@Resource
	private IUserLoginService mUserLoginService;

	public void inserte(UserClientSSearch params) {
		// 用于注册登陆账号
		UserLogin login = new UserLogin();
		login.setAccount(params.getAccount());
		login.setPw(params.getPw());
		mUserLoginService.inserteUser(login);
		// 创建用户详情表
		params.setUserId(login.getId());
		mUserClientMapper.insertSelective(params);
	}

	public void deleteUser(UserClientSSearch params) {
		mUserLoginService.deleteUser(params.getUserId());
		mUserClientMapper.deleteByUserId(params.getUserId());
	}

	public List<UserClientSSearch> findUser(UserClientSSearch params) {
		ModelUtils.initPageParams(params);
		return mUserClientMapper.selectListPageByParams(params);
	}

	public UserClientSSearch findUserByUserId(Integer id) {
		UserClientSSearch params = new UserClientSSearch();
		params.setUserId(id);
		List<UserClientSSearch> list = mUserClientMapper.selectListPageByParams(params);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public void updateUser(UserClientSSearch params) {
		mUserClientMapper.updateByPrimaryKeySelective(params);
	}

	public UserClientSSearch findUserByAccount(String account) {
		UserClientSSearch params = new UserClientSSearch();
		params.setAccount(account);
		List<UserClientSSearch> list = mUserClientMapper.selectListPageByParams(params);
		if (list == null || list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

	public void updateLBi(Double lbi, Integer id) {
		UserClientSSearch user = new UserClientSSearch();
		user.setUserId(id);
		user.setlBi(new BigDecimal(lbi));
		mUserClientMapper.updateLBi(user);
	}

	public Integer getListCountByParams(UserClientSSearch params) {
		return mUserClientMapper.getListCountByParams(params);
	}


}
