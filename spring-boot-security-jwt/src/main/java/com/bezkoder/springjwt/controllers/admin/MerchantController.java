package com.bezkoder.springjwt.controllers.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.payload.request.Merchant;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.security.services.MerchantServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class MerchantController {
	@Autowired
	MerchantServices merchantServices;
	
	
	@GetMapping("/merchant/list")
	public ResponseEntity<Iterable<Merchant>> findAll(){
		try{
			return new ResponseEntity<Iterable<Merchant>>(merchantServices.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<Iterable<Merchant>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/merchant/create")
	public ResponseEntity<Merchant> create(@RequestBody Merchant merchant){
		try{
			
			return new ResponseEntity<Merchant>(merchantServices.save(merchant),HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<Merchant>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
