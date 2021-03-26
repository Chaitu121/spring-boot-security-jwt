package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.payload.request.Location;
import com.bezkoder.springjwt.repository.LocationRepository;

@Service
public class LocationServicesImpl implements LocationServices {
	@Autowired
	LocationRepository locationRepository;

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Location findById(long id) {
		return locationRepository.findById(id).get();
	}

	@Override
	public  Location save( Location loc) {
		
		System.out.println(loc);
		return locationRepository.save(loc);
	}

	

}
