package com.ziejacode.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ziejacode.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	Optional<User> findByUserName(String userName);

	void deleteByUserName(String userName);
	
	
}