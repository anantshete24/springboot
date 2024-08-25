package com.annotations;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration

@ComponentScan(basePackages= {"/com/mypack"})
public class MyConfig {

	@Bean("student1")
	@Lazy
	public Student getStudent()
	{
		System.out.println("Creating First student object");
		
		return new Student("Student1");
	}
	
	@Bean
	 Date getDate()
	{
		System.out.println("Creating new date");
		return new Date();
		
	}
	
	@Bean("student2")
	
	public Student createStudent()
	{
		System.out.println("Creating second student object");
		return new Student("Student2");
	}
}
