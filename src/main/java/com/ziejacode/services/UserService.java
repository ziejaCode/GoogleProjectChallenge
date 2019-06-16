package com.ziejacode.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ziejacode.model.User;

@Service
public interface UserService {
	
	public User updateUser(User user);
	
	public String saveUser(User user);
	
	public User getUserByUserName(String name);
	
	public User getUserByUserId(int i);
	
	public String deleteByUserId(Integer id);
	
	public Set<User> getAllUsers();
	
	
}
