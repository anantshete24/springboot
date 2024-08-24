package com.jwt.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	/*
	@Bean
	public UserDetailsService userDetailService()
	{
		UserDetails user=User.builder().username("anant").password(passwordEncoder().encode("and")).roles("ADMIN").build();
		UserDetails user1=User.builder().username("kim").password(passwordEncoder().encode("kom")).roles("USER").build();
		return new InMemoryUserDetailsManager(user,user1);
	}
	*/
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
