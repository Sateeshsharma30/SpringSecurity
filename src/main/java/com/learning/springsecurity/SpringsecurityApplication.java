package com.learning.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.springsecurity.model.User;
import com.learning.springsecurity.repository.UserRepo;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {

 


	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Autowired
	private UserRepo repos;
	
	
	@Override
	public void run(String... args) throws Exception {

		repos.save(new User("ravi", "password", true, "ROLE_MERCHANT"));
		repos.save(new User("avi", "password", true, "ROLE_USER"));
		System.out.println("User Created");
	}

}
