package com.dealmart.service;

import java.util.List;

import com.dealmart.model.User;

public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	User updateUser(User user, long id);
	
	void deleteUser(long id);
}
