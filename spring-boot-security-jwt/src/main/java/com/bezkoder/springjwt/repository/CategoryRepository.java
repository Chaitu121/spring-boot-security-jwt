package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.Location;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findById(long id);
}
