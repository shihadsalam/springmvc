package com.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.model.User;
import com.webapp.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	public void addUsers (List<User> users) {
		userRepository.saveAll(users);
	}

}
