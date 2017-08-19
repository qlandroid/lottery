package org.ql.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.IUserClientManagerDao;
import org.ql.shopping.pojo.UserClient;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.service.IUserClientManagerService;
import org.ql.shopping.util.StringUtils;
import org.springframework.stereotype.Service;

@Service("userClientMangaerService")
public class UserClientManagerServiceImpl implements IUserClientManagerService {

	@Resource
	private IUserClientManagerDao mUserClientManagerDao;

	public void inserte(UserClientManagerParams params) {
		mUserClientManagerDao.insterUser(params);
		List<UserClient> list = mUserClientManagerDao.findUserLogin(params);
		Long id = list.get(0).getId();
		params.setId(id);
		mUserClientManagerDao.insterUserDetails(params);
	}

	public void deleteUser(UserClientManagerParams params) {
		mUserClientManagerDao.deleteUser(params);
		mUserClientManagerDao.deleteUserDetails(params);
	}

	public List<UserClient> findUser(UserClientManagerParams params) {
		return mUserClientManagerDao.findUser(params);
	}

	public UserClient findUserById(Long id) {
		UserClientManagerParams params = new UserClientManagerParams();
		params.setId(id);
		List<UserClient> list = mUserClientManagerDao.findUser(params);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public void updateUser(UserClientManagerParams params) {
		if (!StringUtils.isEmpty(params.getPw())) {
			mUserClientManagerDao.updateUserPw(params);
		}
		mUserClientManagerDao.updateUserDetails(params);
	}

	public Long getTotalCount(UserClientManagerParams params) {
		return mUserClientManagerDao.getTotalCount(params);
	}

}
