package com.api.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


	//@RequestMapping("/test")
	@GetMapping("/test")
	
	public String Test()
	{
		int a=11111111;
		int b=20;
		int c=200000;
		return "this is just Testing /t sum of a and b is:"+ (a+b+c);
	}

}
