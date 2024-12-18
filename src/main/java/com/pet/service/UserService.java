package com.pet.service;

import java.util.List;
import java.util.Optional;

import com.pet.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	void deleteUserById(Long userId);
	
	User updateUser(User user, Long id);
	
	User registerUser(User user);
	
	Optional<User> getUserById(Long userId);
	
	
	
}
