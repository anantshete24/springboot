package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.repo.CategoryRepo;

@SpringBootTest
class SpringbootworkApplicationTests {

	@Autowired
	private CategoryRepo categoryRepo;
	@Test
	void contextLoads() {
	}
	
	@Test 
	public void testCategoryRepo()
	{
		System.out.println("test started");
		categoryRepo.findAll().forEach(ca-> System.out.println(ca.getTitle()));
	}

}
