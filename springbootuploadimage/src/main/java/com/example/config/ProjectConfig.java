package com.example.config;


import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class ProjectConfig {

	@Bean 
	public ModelMapper mapper()
	{
		return new ModelMapper();
	}
	@Bean
	public Cloudinary getCloudinary()
	{
		Map config =new HashMap();
		config.put("cloud_name", "dln4zqd31");
		config.put("api_key", "344831894415964");
		config.put("api_secret", "Jfv8kYapyzw3CvHEnTdt5GUo-Vg");

		return new Cloudinary(config);
	}
}
