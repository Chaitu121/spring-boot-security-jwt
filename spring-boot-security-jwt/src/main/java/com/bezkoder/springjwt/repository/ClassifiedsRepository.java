package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.payload.request.Classifieds;

public interface ClassifiedsRepository extends JpaRepository<Classifieds, Long> {
	Classifieds findById(long id);
}
