package com.orm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orm.entities.Address;
import com.orm.entities.Category;
import com.orm.entities.Laptop;
import com.orm.entities.Product;
import com.orm.entities.Student;
import com.orm.repository.CategoryRepo;
import com.orm.repository.ProductRepo;
import com.orm.repository.StudentRepository;

@SpringBootApplication
public class SpringbootormApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductRepo productRepo;
	//@Autowired
	//private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(SpringbootormApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootormApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Student student = new Student();
		student.setStudentId(14);
		student.setStudentName("Som");
		student.setAbout("I am a Test Engineer");
		
		Laptop laptop = new Laptop();
		laptop.setLaptopId(12);
		laptop.setModelNumber("13");
		laptop.setBrand("Apple");
		//important
		
		laptop.setStudent(student);
		student.setLaptop(laptop);
		
		try {
			Student save= studentRepository.save(student);
			logger.info("saved student :{}", save.getStudentName());
			
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
		Student student1 =studentRepository.findById(13).get();
		logger.info("Name is {}", student1.getStudentName());
		Laptop laptop1=	student1.getLaptop();
		logger.info("Laptop {}", laptop1.getModelNumber(),laptop.getBrand());
		
		
		Address a1= new Address();
		a1.setAddressId(16);
		a1.setStreet("lkll");
		a1.setCity("Seoul");
		a1.setCountry("South Korea");
		a1.setStudent(student);
	
		Address a2= new Address();
		a2.setAddressId(2222);
		a2.setStreet("bkjhbjkhb");
		a2.setCity("Von bon");
		a2.setCountry("Vietnam ");
		a2.setStudent(student);
		
		List<Address>addressList= new ArrayList<>();
		addressList.add(a1);
		addressList.add(a2);
		
		student.setAddressList(addressList);
		Student save=studentRepository.save(student);
		logger.info("Student Created : with address");
		
		Product product1 = new Product();
		product1.setpId("id1");
		product1.setProductName("iPhone 14 Max Pro");
		
		Product product2 = new Product();
		product2.setpId("id2");
		product2.setProductName("Samsung S2 Ultra");
		
		Product product3 = new Product();
		product3.setpId("id3");
		product3.setProductName("Samsung TV12343");
		
		Category category1 = new Category();
		category1.setcId("cid1");
		category1.setTitle("Electronics");
		
		Category category2 = new Category();
		category2.setcId("cid2");
		category2.setTitle("Mobile Phone");	
		
		List<Product>category1Products=category1.getProduct();
		category1Products.add(product1);
		category1Products.add(product2);
		category1Products.add(product3);
		
		List<Product>category2Products=category2.getProduct();
		category2Products.add(product1);
		category2Products.add(product2);
		
		categoryRepo.save(category1);
		categoryRepo.save(category2);
		
		
		Category category=categoryRepo.findById("cid1").get();
		System.out.println("Category 1"+category.getProduct().size());
		
		Category category1=categoryRepo.findById("cid2").get();
		System.out.println("Category 2"+category1.getProduct().size());
		*/
		Product product=productRepo.findById("id3").get();
		System.out.println("Product 1"+product.getCategory().size());
		System.out.println("Product 11"+" "+product.getpId());
		System.out.println("Product 11"+" "+product.getProductName());
	}
		

}
