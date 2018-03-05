package com.codingdojo.test.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.test.models.User;
import com.codingdojo.test.repositories.RoleRepository;
import com.codingdojo.test.repositories.UserRepository;

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
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public User findById(Long userId) {
		return userRepository.findOne(userId);
	}

	public void addConnect(Long reqId, Long coolId) {
		User requester = userRepository.findOne(reqId);
		User coolGuy = userRepository.findOne(coolId);
		List<User> friends = coolGuy.getRequestingFriends();
		friends.add(requester);
		userRepository.save(friends);
	}
	
	public List<User> findYourFriends(Long userId) {
		User user = userRepository.findOne(userId);
		List<User> yourFriends = user.getUserFriends();
		return yourFriends;
	}

	public void removeTemp(Long frId, Long yourId) {
		User requester = userRepository.findOne(frId);
		User coolGuy = userRepository.findOne(yourId);
		List<User> friends = coolGuy.getRequestingFriends();
		friends.remove(requester);
		userRepository.save(friends);
	}

	public void confirmConnect(Long frId, Long yourId) {
		User requester = userRepository.findOne(frId);
		User coolGuy = userRepository.findOne(yourId);
		List<User> friends = coolGuy.getUserFriends();
		friends.add(requester);
		userRepository.save(friends);
	}
	
}
