package com.pet.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String userEmail);

}
