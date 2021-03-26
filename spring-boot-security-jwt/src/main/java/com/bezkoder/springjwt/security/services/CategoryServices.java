package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.validation.Valid;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.payload.request.Location;

public interface CategoryServices {
	List<Category> findAll();
	Category findById(long id);
	void save(@Valid Category addCategory);
}
