package com.pet.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.User;
import com.pet.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@GetMapping()
	public Optional<List<User>> getAllUsers(){
		
		Optional<List<User>> users= Optional.ofNullable(userServiceImpl.getAllUsers());
		return users;
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Long id){
		return userServiceImpl.getUserById(id);
		
	}
	
	@PostMapping()
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User users= userServiceImpl.registerUser(user);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userServiceImpl.updateUser(user, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUserById(id);
	}
	
	
}
