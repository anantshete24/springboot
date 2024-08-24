package com.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.dao.StudentDao;

@SpringBootApplication
public class BootwithpostgresApplication implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;
	public static void main(String[] args) {
		SpringApplication.run(BootwithpostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//this.studentDao.createTable();
		this.studentDao.insertData("Anant", "Munich");
	}

}
