package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.payload.request.Location;
import com.bezkoder.springjwt.repository.CategoryRepository;
import com.bezkoder.springjwt.repository.LocationRepository;

@Service
public class CategoryServicesImpl  implements CategoryServices{
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(long id) {
		
		return categoryRepository.findById(id);
	}

	@Override
	public void save(@Valid Category addCategory) {
		
		categoryRepository.save(addCategory);
	}

}
