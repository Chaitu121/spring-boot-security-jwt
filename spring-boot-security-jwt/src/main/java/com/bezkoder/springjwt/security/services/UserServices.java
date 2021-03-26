package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.Location;

public interface UserServices {

	User findById(long id);
	public void save(User user);
}
