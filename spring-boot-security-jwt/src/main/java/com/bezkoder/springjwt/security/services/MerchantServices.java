package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.payload.request.Merchant;

public interface MerchantServices {
	 public Iterable<Merchant> findAll();
	  public Merchant save(Merchant merchant);

}
