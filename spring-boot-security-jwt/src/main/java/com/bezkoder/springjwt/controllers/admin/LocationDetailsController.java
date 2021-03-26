package com.bezkoder.springjwt.controllers.admin;

import java.awt.PageAttributes.MediaType;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bezkoder.springjwt.payload.request.Location;
import com.google.common.net.HttpHeaders;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class LocationDetailsController {
	
	@Autowired
	static
	RestTemplate restTemplate;
	final String baseUrl="https://maps.googleapis.com/maps/api/geocode/json?latlng=16.7559759,81.6802045&key=AIzaSyBAMYFGB8QwlV_bUVh8aPIkUavByvLumi8";
	static String baseUrl2="&key=AIzaSyBAMYFGB8QwlV_bUVh8aPIkUavByvLumi8";

	@GetMapping("/location/details")
	public static void  getUser(){
		
	     
	       //restTemplate.exchange("https://maps.googleapis.com/maps/api/geocode/json?latlng=16.7559759,81.6802045&key=AIzaSyBAMYFGB8QwlV_bUVh8aPIkUavByvLumi8", HttpMethod.GET, entity, String.class).getBody();
	   
		//return new ResponseEntity<>(restTemplate.exchange(baseUrl, HttpMethod.POST), HttpStatus.OK);
	}

}
