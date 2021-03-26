package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.payload.request.Merchant;
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
