package com.tweetapp.tweetconsoleapp;

import com.tweetapp.tweetconsoleapp.controller.AppHomeController;
import com.tweetapp.tweetconsoleapp.controller.UserController;
import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.service.UserService;
import com.tweetapp.tweetconsoleapp.util.CmdLineInputs;
import com.tweetapp.tweetconsoleapp.util.DateUtil;
import com.tweetapp.tweetconsoleapp.util.OnScreenMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
public class TweetAppConsoleApplication implements CommandLineRunner {
	@Autowired
	UserService userService ;
	@Autowired
	AppHomeController appHomeController;
	@Autowired
	UserController userController;

	public static void main(String[] args) {

		SpringApplication.run(TweetAppConsoleApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		UserDetails userDetails = new UserDetails("vishnu@gmail.com","vis","vis","vis","male", DateUtil.parse("14-08-1999"), "911",false);
		userService.registerUser(userDetails);
		userService.getAllUsers().forEach(System.out::println);

		appHomeController.launchApp();

		CmdLineInputs.closeBr();
	}
}
