package com.capp.service;

import java.util.List;

import com.capp.domain.User;
import com.capp.exception.UserBlockedException;

/*
 * This method is used for login(authentication), if user found it returns
 * user object else null when failed;
 */

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	
	public void register(User u);
	public void login();
	
	/**
	 * This method is used for login(authentication), if user found it returns
	 * user object else null when failed;
	 * @param loginName
	 * @param password
	 * @return
	 * @throws UserBlockedException
	 */
	public User login(String loginName, String password) throws UserBlockedException;
	
	/**
	 * This method will return registered users.
	 * @return
	 */
	public List<User> getUserList();
	
	/**
	 * This method is used to change the login status.
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus) ;
	
	public Boolean isUsernameExist(String username);

}
