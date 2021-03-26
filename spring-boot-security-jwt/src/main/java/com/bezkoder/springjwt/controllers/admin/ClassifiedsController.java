package com.bezkoder.springjwt.controllers.admin;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.security.services.ClassifiedsServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class ClassifiedsController {

	
	@Autowired
	ClassifiedsServices  classifiedsService;
	
	@GetMapping("/classifieds/list")
	public ResponseEntity<Iterable<Classifieds>> findAll(){
		try{
			return new ResponseEntity<Iterable<Classifieds>>(classifiedsService.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<Iterable<Classifieds>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/classifieds/create")
	public ResponseEntity<Classifieds> create(@RequestBody Classifieds classifieds){
		try{
			return new ResponseEntity<Classifieds>(classifiedsService.save(classifieds),HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<Classifieds>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	
}
