package com.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Book book = new Book();
		book.setTitle("My First Book");
		book.setConent("this is contect of first book");
		book.setAuthor("Kim");
		book.setPages(120);
		Book book1 = new Book();
		book1.setTitle("My First Book");
		book1.setConent("this is contect of first book");
		book.setAuthor("Tim");
		book.setPages(541);
		this.bookRepository.save(book);
		this.bookRepository.save(book1);
}

}
