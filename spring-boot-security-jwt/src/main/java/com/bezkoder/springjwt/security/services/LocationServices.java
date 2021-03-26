package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.validation.Valid;

import com.bezkoder.springjwt.payload.request.Location;


public interface LocationServices {
	List<Location> findAll();
	Location findById(long id);
	Location save(@Valid Location addlocation);
}
