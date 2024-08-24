package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository =context.getBean(UserRepository.class);
		/*
		User user= new User();
		user.setName("KQL");
		user.setCity("Mumbai");
		user.setStatus("Android Developer");
		User user1=userRepository.save(user);
		System.out.println(user1);
		*/
		// create object of User
		//add multiple users
	/*
		User user1 = new User();
		user1.setName("Kelly");
		user1.setCity("London");	
		user1.setStatus(".NET Developer");
		
		
		User user2 = new User();
		user2.setName("Meow");
		user2.setCity("Shanghai");	
		user2.setStatus("C++ Developer");
		
		User resultUser=userRepository.save(user1);
		System.out.println(resultUser);
		userRepository.save(user2);
		List<User> users=List.of(user1, user2);
		//save multiple objects
		userRepository.saveAll(users);
		Iterable <User> result=userRepository.saveAll(users);
		result.forEach(user->{
			System.out.println(user);
		});
		
	*/
		
		// update user of id 53
		Optional <User>optional=userRepository.findById(11);
		User user=optional.get();
		user.setName("Nolan");
		user.setCity("Amsterdam");
		user.setStatus("Android developer");
		User result=userRepository.save(user);
		System.out.println(result);
		
		
		//how to get the data
		//findById(id) > return optional containing your data
		Iterable<User> itr=userRepository.findAll();
		
		/* old way
		Iterator<User> iterator= itr.iterator();
		
		while(iterator.hasNext())
		{
			User user2 = iterator.next();
			System.out.println(user2);
		}
		*/
		//lambda function
		
	//	itr.forEach(user->{System.out.prinln(user);});
		
		/*
		//Deleting the user Element
		
		userRepository.deleteById(53);
		System.out.println(user);
		
		//delete all user
		Iterable<User>allUsers=userRepository.findAll();
		//allUsers.forEach(user->System.out.println(user));
		//userRepository.deleteAll(allUsers); // it will delete all users	
		try {
		List <User> users=userRepository.findByName("kelly");
		users.forEach(e->System.out.println(e));
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element Error +++++"+e);
		}
		
		*/
		
		List<User> allUser=userRepository.getAllUser();
		allUser.forEach(e->{System.out.println(e);});
		
		System.out.println("one+++++++++++++++");
	
		List<User> userByName=userRepository.getUserByName("kelly");
		userByName.forEach(e->{System.out.println(e);});
		System.out.println("two+++++++++++++++");
		List<User> userByName1=userRepository.getUserByName("kelly", "Paris");
		userByName1.forEach(e->{System.out.println(e);});
		System.out.println("three`+++++++++++++++");
		
		
		userRepository.getUsers().forEach(e->System.out.println(e));
	}
	

}
