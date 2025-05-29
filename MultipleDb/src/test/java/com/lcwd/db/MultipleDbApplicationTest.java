package com.lcwd.db;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.db.mysql.repo.UserRepo;
import com.lcwd.db.postgres.entities.Product;
import com.lcwd.db.postgres.repo.ProductRepo;

@SpringBootTest
public class MultipleDbApplicationTest {
/*
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProductRepo productRepo;
	
	@Test
	public void dbTest()
	{
		User user=User.builder()
		.firstName("Anant")
		.lastName("shete")
		.email("adb@gmail.com")
		.build();
		System.out.println("testing");
		
		Product product = Product.builder()
				.name("Apple iPhone")
				.id("74000")
				.live(true)
				.description("this is apple product")
				.build();
		
		
		productRepo.save(product);
		userRepo.save(user);
		System.out.println("data saved!!!");
	}
	
	@Test
	public void getData()
	{
		productRepo.findAll().forEach(product-> System.out.println(product.getName()));
		userRepo.findAll().forEach(user->System.out.println(user.getUserName()));
	}
	*/
	
	@Test
	public void dbTest()
	{
		System.out.println("Testing");
	}
}
