package com.tweetapp.tweetconsoleapp;

import com.tweetapp.tweetconsoleapp.controller.AppHomeController;
import com.tweetapp.tweetconsoleapp.controller.TweetController;
import com.tweetapp.tweetconsoleapp.controller.UserController;
import com.tweetapp.tweetconsoleapp.util.CommandLineInputs;
import com.tweetapp.tweetconsoleapp.util.ReadCSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TweetAppConsoleApplication implements CommandLineRunner {
	@Autowired
	AppHomeController appHomeController;
	@Autowired
	UserController userController;
	@Autowired
	TweetController tweetController;

	public static void main(String[] args) {

		SpringApplication.run(TweetAppConsoleApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		loadTestData();
		appHomeController.launchApp();
	}

	private void loadTestData() throws IOException {
		List<String[]> usersListFromCSV= ReadCSVUtil.getObjectsFromCSV("src/main/resources/userDetails.csv");
		List<String[]> tweetListFromCSV= ReadCSVUtil.getObjectsFromCSV("src/main/resources/tweets.csv");
		for(int i=0;i<usersListFromCSV.size();i++){
			userController.registerUser(
					usersListFromCSV.get(i)[0],
					usersListFromCSV.get(i)[1],
					usersListFromCSV.get(i)[2],
					usersListFromCSV.get(i)[3],
					usersListFromCSV.get(i)[4],
					usersListFromCSV.get(i)[5],
					usersListFromCSV.get(i)[6]
			);
			tweetController.postTweet(
					usersListFromCSV.get(i)[0],
					usersListFromCSV.get(i)[2],
					usersListFromCSV.get(i)[3],
					tweetListFromCSV.get(i)[0]
			);
		}
	}
}
