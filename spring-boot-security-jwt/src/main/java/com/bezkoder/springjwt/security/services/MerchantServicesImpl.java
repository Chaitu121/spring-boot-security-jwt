package com.bezkoder.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.payload.request.Merchant;
import com.bezkoder.springjwt.repository.MerchantRepository;

@Service
public class MerchantServicesImpl implements MerchantServices {
@Autowired
MerchantRepository merchantRepository ;

	
	
	
	@Override
	public Iterable<Merchant> findAll() {
		
		return merchantRepository.findAll();
	}

	@Override
	public Merchant save(Merchant merchant) {
		
		return merchantRepository.save(merchant);
	}

}
