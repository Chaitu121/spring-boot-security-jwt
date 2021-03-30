package com.bezkoder.springjwt.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.springjwt.payload.request.Classifieds;
import com.bezkoder.springjwt.security.services.ClassifiedsServices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class ClassifiedsController {

	
	@Autowired
	ClassifiedsServices  classifiedsService;
	@Autowired ServletContext context;
	
	

	
	@GetMapping("/classifieds/list")
	public ResponseEntity<List<Classifieds>> findAll(){
		try{
			List<Classifieds> popst=classifiedsService.findAll();
			for (Classifieds name : popst) {
		        System.out.println(name);
		    }
			
			return new ResponseEntity<List<Classifieds>>(classifiedsService.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<List<Classifieds>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/classifieds/{id}")
	
	
	 public void picture(HttpServletResponse response, @PathVariable Long id) {
		  
			  Classifieds chs=classifiedsService.findById(id);
        File imageFile = new File("hello"+"/"+chs.getFileName());
        System.out.println(imageFile);
		
    }
	/*
	 * public ResponseEntity<List<Classifieds>> findAllImages(){ try{
	 * List<Classifieds> imagesList=classifiedsService.findAll();
	 * 
	 * 
	 * 
	 * return new
	 * ResponseEntity<List<Classifieds>>(classifiedsService.findAll(),HttpStatus.OK)
	 * ; }catch(Exception e) {
	 * 
	 * return new ResponseEntity<List<Classifieds>>(HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 */
	
	/*
	 * @PostMapping("/classifieds/create" ) public ResponseEntity<Classifieds>
	 * create(@RequestParam("picByte") MultipartFile picByte,@RequestParam("user")
	 * String user) throws JsonParseException,JsonMappingException,IOException{
	 * 
	 * 
	 * try{
	 * 
	 * 
	 * System.out.println(user); Classifieds classifieds=new
	 * ObjectMapper().readValue(user,Classifieds.class);
	 * classifieds.setPicByte(picByte.getBytes());
	 * classifieds.setFileName(picByte.getOriginalFilename());
	 * classifieds.setCreateddate(new Date()); System.out.println(user); return new
	 * ResponseEntity<Classifieds>(classifiedsService.save(classifieds),HttpStatus.
	 * OK); }catch(Exception e) { Classifieds classifieds=new
	 * ObjectMapper().readValue(user,Classifieds.class);
	 * classifieds.setPicByte(picByte.getBytes());
	 * classifieds.setFileName(picByte.getOriginalFilename());
	 * System.out.println(user); return new
	 * ResponseEntity<Classifieds>(classifieds,HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 */
	
	@PostMapping("/classifieds/create" )
	public ResponseEntity<Classifieds> create(@RequestParam("picByte") MultipartFile picByte,@RequestParam("user") String user) throws JsonParseException,JsonMappingException,IOException{
		
		
		try{
			
		
			System.out.println(user);
			Classifieds classifieds=new ObjectMapper().readValue(user,Classifieds.class);
			classifieds.setPicByte(picByte.getBytes());
			classifieds.setFileName(picByte.getOriginalFilename());
			classifieds.setCreateddate(new Date());
			boolean isExists=context.getRealPath("/userProfile/").isEmpty();
			System.out.println(isExists);
			if(isExists) {
				new File(context.getRealPath("/userProfile")).mkdir();
			}
			String filename=picByte.getOriginalFilename();
			String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
			
			File serverfile=new File(context.getRealPath("userProfile/"+File.separator+modifiedFileName));
			FileUtils.writeByteArrayToFile(serverfile,picByte.getBytes());

			classifieds.setFileName(modifiedFileName);
			System.out.println(user);
			return new ResponseEntity<Classifieds>(classifiedsService.save(classifieds),HttpStatus.OK);
		}catch(Exception e) {
			Classifieds classifieds=new ObjectMapper().readValue(user,Classifieds.class);
			classifieds.setPicByte(picByte.getBytes());
			classifieds.setFileName(picByte.getOriginalFilename());
			System.out.println(user);
			return new ResponseEntity<Classifieds>(classifieds,HttpStatus.BAD_REQUEST);
		}
		
	}

	
}
