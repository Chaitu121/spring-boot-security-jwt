package com.bezkoder.springjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
		final RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<String> ResponseEntity= restTemplate.getForEntity("https://maps.googleapis.com/maps/api/geocode/json?latlng=16.7559759,81.6802045&key=AIzaSyBAMYFGB8QwlV_bUVh8aPIkUavByvLumi8",  String.class);
		String body=ResponseEntity.getBody();
		System.out.println(body);
	}

}
