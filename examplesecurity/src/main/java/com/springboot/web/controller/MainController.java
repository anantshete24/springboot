package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/home")
	public String home()
	{
		System.out.println("this is home page");
		return "home";
	}
	
	@GetMapping("/contact")
	public String contact()
	{
		System.out.println("this is contact page");
		return "contact";
	}
}
