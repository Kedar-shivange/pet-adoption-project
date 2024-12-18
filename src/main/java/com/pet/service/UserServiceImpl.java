package com.pet.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pet.model.User;
import com.pet.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long userId){
		return Optional.of(userRepository.findById(userId).orElseThrow(
				()-> new RuntimeException("User not found")));
	}
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user, Long id) {
		Optional<User> users= userRepository.findById(id);
		if(users.isPresent()) {
			User userId=users.get();
			
			userId.setName(user.getName());
			userId.setEmail(user.getEmail());
			userId.setPass(user.getPass());
			
			return userRepository.save(userId);
		}else {
			throw new RuntimeException("User Not found");
		}
	}
	
	public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);
	}
}
