package com.codingdojo.ideas.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.ideas.models.User;
import com.codingdojo.ideas.repositories.RoleRepository;
import com.codingdojo.ideas.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
//	Saves a client with only the user role.
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	
//	Saves a client with only the admin role.
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}
	
//	Finds a user by their username.
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}
	
}
