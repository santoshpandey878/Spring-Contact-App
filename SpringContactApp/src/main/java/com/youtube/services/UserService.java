package com.youtube.services;

import java.util.List;

import com.youtube.domain.User;
import com.youtube.exception.UserBlockedException;

public interface UserService {
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	
	// handle the user registartion task
	public void register(User u);
	
	/* 
	 * the method handle login operation(authentication) using given credentials
	 * it returns user object when success and null when failed
	 * When user account is blocked an exception is thrown by this method
	 * @param loginName
	 * @param password
	 * @return
	 * @throws com.youtube.exception.UserBlockedException when user account is blocked
	 */
	public User login(String loginName, String password) throws UserBlockedException;
	
	// call this method to get list of registered users
	public List<User> getUserList();
	
	/*
	 * This method change the user login status for details passed as arguments
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	
	/*
	 * check the user name availability
	 */
	public Boolean isUserNameExist(String userName);
}
