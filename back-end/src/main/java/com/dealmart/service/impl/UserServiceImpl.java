package com.dealmart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dealmart.exception.ResourceNotFoundException;
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




	@Override
	public  List<User> getAllUsers() {
		return userRepository.findAll();
	}




	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "Id", id));
	}




	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("User", "Id", id));
		
		existingUser.setFullName(user.getFullName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setPaymentDetails(user.getPaymentDetails());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		
		userRepository.save(existingUser);
		
		return existingUser;
	}




	@Override
	public void deleteUser(long id) {
		
		userRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}
	
}
