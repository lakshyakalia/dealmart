package com.dealmart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealmart.model.User;
import com.dealmart.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted Successfully!", HttpStatus.OK);
	}
}
