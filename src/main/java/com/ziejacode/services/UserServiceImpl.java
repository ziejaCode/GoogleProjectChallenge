package com.ziejacode.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ziejacode.model.User;
import com.ziejacode.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {		
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public User updateUser(User user) {	
		User savedUser = null;
		if(!(user == null)) {
			savedUser = userRepository.save(user);
		}		
		System.out.println("test4 user " + user.getUserName());
        return savedUser;		
	}
	
	@Override
	@Transactional
	public String saveUser(User user) {
		userRepository.save(user);
		return "User Saved";
	}
	
	@Override
	public User getUserByUserName(String name) {	
		Optional<User> returned = userRepository.findByUserName(name);
		return returned.get();
	}
	
	@Override
	public User getUserByUserId(int id) {		
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
            throw new RuntimeException("User Not Found!");
        }
        return userOptional.get();
	}

	@Override
	public String deleteByUserId(Integer id) {
		userRepository.deleteById(id);
		return "Usere no. " + id + " was deleted";
	}	
	
	@Override
	public Set<User> getAllUsers() {
		Set<User> userSet = new HashSet<>();
		userRepository.findAll()
		.iterator().forEachRemaining(userSet::add);
	    return userSet;
	}

}
