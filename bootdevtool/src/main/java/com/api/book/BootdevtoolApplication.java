package com.api.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.api.book.helper","com.api.book.services"})
public class BootdevtoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootdevtoolApplication.class, args);
	}

}
