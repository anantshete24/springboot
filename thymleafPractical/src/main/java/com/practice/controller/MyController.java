package com.practice.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController {

	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about(Model model)
	{
		model.addAttribute("name", "Anant Shete");
		model.addAttribute("currentDate", new Date().toLocaleString());
		System.out.println("Inside about handler");
		String nameString="abc";
		nameString.toUpperCase();
		return "about";
	}
	
	//handling iteration
	@GetMapping("/example-loop")
	public String iterateHandler(Model m)
	{
		List<String> names = List.of("Anant","Karen","Mia","Sunny");
		m.addAttribute("names",names);
		//create a list
		return "iterate";
	}
	@GetMapping("/condition")
	public String conditionHandler(Model m)
	{
		System.out.println("Conditional handler executed");
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "F");
		
		List<Integer> list = List.of(10,20,30);		
		m.addAttribute("mylist", list);
		return "condition";
		
	}
	//handler for including fragments
	@GetMapping("/service")
	public String servicesHandler(Model m)
	{
		m.addAttribute("title", "I like to eat Samosa");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "service";
	}
	
	@GetMapping("/newabout")
	public String newAbout()
	{
		return "aboutnew";
		
	}

	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
		
	}
}
