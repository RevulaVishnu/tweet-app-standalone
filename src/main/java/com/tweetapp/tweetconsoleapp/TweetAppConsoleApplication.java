package com.tweetapp.tweetconsoleapp;

import com.tweetapp.tweetconsoleapp.controller.AppHomeController;
import com.tweetapp.tweetconsoleapp.controller.UserController;
import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.service.UserService;
import com.tweetapp.tweetconsoleapp.util.CommandLineInputs;
import com.tweetapp.tweetconsoleapp.util.DateUtil;
import com.tweetapp.tweetconsoleapp.util.ReadCSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
		List<String[]> objList= ReadCSVUtil.getObjectsFromCSV("src/main/resources/userDetails.csv");
		for(String[] objArr: objList){
			String arg="";
			userController.registerUser(objArr[0],objArr[1],objArr[2],objArr[3],objArr[4],objArr[5],objArr[6]);
		}
		userService.getAllUsers().forEach(System.out::println);

		appHomeController.launchApp();

		CommandLineInputs.closeBr();
	}
}
