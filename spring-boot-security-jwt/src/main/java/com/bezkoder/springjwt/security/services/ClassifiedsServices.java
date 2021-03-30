package com.bezkoder.springjwt.security.services;

import java.util.List;

import com.bezkoder.springjwt.payload.request.Classifieds;

public interface ClassifiedsServices {
  public List<Classifieds> findAll();
  public Classifieds save(Classifieds classifieds);
  public Classifieds findById(long id);
}
