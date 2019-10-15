package com.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.exception.UserBlockedException;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;

	public void register(User u) {
		userDAO.save(u);

	}

	public void login() {
		// TODO Auto-generated method stub

	}

	public User login(String loginName, String password) throws UserBlockedException {

		User u = userDAO.findUserByUsernameAndPwd(loginName, password);

		if (u != null && u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
			throw new UserBlockedException("Your account has been blocked. Contact Admin");
		}

		return u;
	}

	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {

		String sql = "update user SET loginStatus=:lStatus where userId=:uId";
		Map m = new HashMap();
		m.put("uId", userId);
		m.put("lStatus", loginStatus);
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	public Boolean isUsernameExist(String username) {
		String sql = "Select count(loginName) from user where loginName=?";
		
		Integer count = getJdbcTemplate().queryForObject(sql, new String[] {username}, Integer.class);
		if (count == 1) {
			return true;
		}else {
			return false;
		}
	}

}
