package com.dealmart.service.impl;

import org.springframework.stereotype.Service;

import com.dealmart.model.User;
import com.dealmart.repository.UserRepository;
import com.dealmart.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}




	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
}
