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

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.CategoryRepository;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.CategoryServices;
import com.bezkoder.springjwt.security.services.LocationServices;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class CategoryController  {
	
	
	@Autowired
	CategoryServices categoryService;
	
	
	
	@Autowired
	PasswordEncoder encoder;
	@GetMapping("/category/list")
	public ResponseEntity<?> getUser(){
		List<Category> uds=categoryService.findAll();
		System.out.println(uds);
		return new ResponseEntity<>(uds, HttpStatus.OK);
	}
	@PostMapping("/category/create")
	public ResponseEntity<?> registerLocation(@Valid @RequestBody Category  category) {
		categoryService.save(category);
		return ResponseEntity.ok(new MessageResponse("category registered successfully!"));
	}
}