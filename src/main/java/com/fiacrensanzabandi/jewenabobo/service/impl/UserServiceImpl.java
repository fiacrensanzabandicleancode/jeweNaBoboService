package com.fiacrensanzabandi.jewenabobo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiacrensanzabandi.jewenabobo.model.User;
import com.fiacrensanzabandi.jewenabobo.model.repository.UserRepository;
import com.fiacrensanzabandi.jewenabobo.service.UserService;

/**
 * User service.
 * 
 * @author fnsanzabandi
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUserByName(User user) {
		return userRepository.findByName(user.getName());
	}

	@Override
	public boolean verifyIfUserExists(User user) {
		return userRepository.findByNameAndPassword(user.getName(), user.getPassword()) != null;
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);		
	}

}
