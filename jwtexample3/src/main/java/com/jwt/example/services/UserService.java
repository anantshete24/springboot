package com.jwt.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.example.entities.User;
import com.jwt.example.repositories.UserRepository;

@Service
public class UserService {

	private List<User> store=new ArrayList();

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User>getUsers()
	{
		return this.store;
		
	}
	
	public User createUser(User user)
	{
		user.setUserId(UUID.randomUUID().toString());
		user.setPassowrd(passwordEncoder.encode(user.getPassowrd()));
		return userRepository.save(user);
		
	}
}
