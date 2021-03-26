package com.bezkoder.springjwt.security.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.UserServices;
@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	UserRepository userRepository;
	@Override
	public User findById(long id) {
		
		return userRepository.findById(id);
	}
	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

}
