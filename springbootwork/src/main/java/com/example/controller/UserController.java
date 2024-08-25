package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.User;
import com.example.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/users")
public class UserController {

	private Logger logger=LoggerFactory.getLogger(UserController.class);	
	@Autowired
	private ObjectMapper mapper;
	
	@PostMapping

	public ResponseEntity<?> addUserInformation(@RequestParam("file")MultipartFile file,
			@RequestParam("userData")String userData)
	{
		this.logger.info("Add user information");
		logger.info("File Information{}", file.getOriginalFilename());
		logger.info("user:{}",userData);		
		//converting String into JSON
		
		User user= null;
		try {
		
			user = mapper.readValue(userData, User.class);
		} 
		catch (JsonProcessingException e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
			
		}
		//file save, user save
		this.logger.info("User date is {}", user);
		
		UserModel userModel = new UserModel(1,"Anant","Munich",null);
		return ResponseEntity.ok(user);
	}
}
