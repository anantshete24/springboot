package com.learn.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.helper.Student;

@RestController
public class HomeController {

	@Autowired
	
	private Student student;
	
	@GetMapping("/get-data")
	@ResponseBody
	public Map<String, String> getData()
	{

		return Map.of("Key1","Name", "Key2","Anant Shete");
	
	}
}
