package org.ql.shopping.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.user.IUserClientManagerDao;
import org.ql.shopping.pojo.params.UserClientManagerParams;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.util.StringUtils;
import org.springframework.stereotype.Service;

@Service("userClientMangaerService")
public class UserClientManagerServiceImpl implements IUserClientManagerService {

	@Resource
	private IUserClientManagerDao mUserClientManagerDao;

	public void inserte(UserClientManagerParams params) {
		mUserClientManagerDao.insterUser(params);
		params.setId(params.getId());
		mUserClientManagerDao.insterUserDetails(params);
	}

	public void deleteUser(UserClientManagerParams params) {
		mUserClientManagerDao.deleteUser(params);
		mUserClientManagerDao.deleteUserDetails(params);
	}

	public List<UserClient> findUser(UserClientManagerParams params) {
		Long firstIndex = (long) ((params.getPage() - 1) * params.getPageSize());
		params.setFirstIndex(firstIndex);
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

	public UserClient findUserByAccount(String account) {
		UserClientManagerParams u = new UserClientManagerParams();
		u.setAccount(account);
		List<UserClient> list = mUserClientManagerDao.findUser(u);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public void updateLBi(Double lbi, Integer id) {
		UserClient user = new UserClient();
		user.setUserId(id);
		user.setlBi(lbi);
		mUserClientManagerDao.updateLBi(user);
	}

}
