package com.bezkoder.springjwt.security.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.repository.ClassifiedsRepository;
import com.bezkoder.springjwt.security.services.ClassifiedsServices;
@Service
public class ClassifiedsServicesImpl implements ClassifiedsServices {
@Autowired
ClassifiedsRepository classifiedsRepository;
	@Override
	public List<Classifieds> findAll() {
		
		return classifiedsRepository.findAll();
	}

	@Override
	public Classifieds save(Classifieds classifieds) {
		
		return classifiedsRepository.save(classifieds);
	}
	@Override
	  public Classifieds findById(long id) {
		return classifiedsRepository.findById(id);
	}

}
