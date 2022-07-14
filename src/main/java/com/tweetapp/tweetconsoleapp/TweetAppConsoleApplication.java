package com.tweetapp.tweetconsoleapp;

import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TweetAppConsoleApplication implements CommandLineRunner {
	@Autowired
	UserService userService ;

	public static void main(String[] args) {

		SpringApplication.run(TweetAppConsoleApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Enter name:");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		UserDetails userDetails = new UserDetails(name,"vis","vis","vis","m","14-08-1999","911");
		userService.registerUser(userDetails);
		userService.getAllUsers().forEach(userDetails1 -> System.out.println(userDetails));
	}

}
