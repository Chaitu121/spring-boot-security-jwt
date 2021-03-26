package com.bezkoder.springjwt.controllers.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.payload.request.Location;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.LocationServices;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class LocationController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LocationServices locationService;
	
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	@GetMapping("/location/list")
	public ResponseEntity<?> getUser(){
		List<Location> uds=locationService.findAll();
		System.out.println(uds);
		return new ResponseEntity<>(uds, HttpStatus.OK);
	}
	@PostMapping("/location/create")
	public ResponseEntity<Location> registerLocation( @RequestBody Location  addlocation) {
		System.out.println(addlocation);
		try{
			return new ResponseEntity<Location>(locationService.save(addlocation),HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<Location>(HttpStatus.BAD_REQUEST);
		}
		
		//return ResponseEntity.ok(new MessageResponse("Location registered successfully!"));
	}
}
