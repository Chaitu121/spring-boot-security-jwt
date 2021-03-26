package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.payload.request.Classifieds;

public interface ClassifiedsServices {
  public Iterable<Classifieds> findAll();
  public Classifieds save(Classifieds classifieds);
}
