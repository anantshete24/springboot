package com.annotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.annotations.Student;

@Controller
@RestController
public class MyController {
	
	@Autowired
	@Qualifier("student1")
	private Student student;

	@RequestMapping(value="/home",method=RequestMethod.GET)
	
	public Student home(@RequestBody Student st)
	{
		st.studying();
		System.out.println("this is home method");
		this.student.setName("Anant Shete");
		return this.student;
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public String user(@RequestParam("userId") String userId)
	{
		//form data comes in @RequestParam
		return userId;
	}
}
