package com.tweetapp.tweetconsoleapp.controller;

import com.tweetapp.tweetconsoleapp.model.Tweet;
import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.service.TweetService;
import com.tweetapp.tweetconsoleapp.service.UserService;
import com.tweetapp.tweetconsoleapp.util.CmdLineInputs;
import com.tweetapp.tweetconsoleapp.util.OnScreenMessages;
import com.tweetapp.tweetconsoleapp.util.TweetValidator;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class TweetController {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    UserService userService;
    @Autowired
    TweetService tweetService;
    
    public void postTweet(UserDetails user) throws IOException {
        OnScreenMessages.showDisplayMessage("Post a Tweet");
        System.out.println("\t\tEnter Your Tweet(Max 300 chars): [PRESS ENTER TO POST YOUR TWEET]");
        String tweetInput = CmdLineInputs.readInput();

        List<String> validationErrors = TweetValidator.validate(tweetInput);
        if (validationErrors.isEmpty()) {
            Tweet tweet = new Tweet(user.getEmail(), tweetInput, user.getFirstName()+" "+user.getLastName(), null );
            tweetService.postTweet(tweet);
        } else {
            OnScreenMessages.showMessage("Validation Failed!");
            validationErrors.forEach(error -> System.out.println("\t\tERROR -> " + error));
        }
    }

    public void viewMyTweets(UserDetails user) {
        OnScreenMessages.showDisplayMessage("Your Tweets");
        List<Tweet> myTweets = tweetService.getTweetsByEmail(user.getEmail());
        System.out.println();
        if (myTweets.isEmpty()) {
            OnScreenMessages.showMessage("No Tweets to show.");
        } else {
            myTweets.forEach(TweetController::displayTweet);
        }
    }

    public static void displayTweet(Tweet tweet) {
        System.out.println("Tweet -> " + tweet.getTweet());
        System.out.println("by: " + tweet.getTweetedBy() + "\tat: " + tweet.getCreatedAt());
        System.out.println();
    }

    public void viewAllTweets() {
        OnScreenMessages.showDisplayMessage("All Tweets");
        List<Tweet> allTweets = tweetService.getAllTweets();
        System.out.println();
        if (allTweets.isEmpty()) {
            OnScreenMessages.showMessage("No Tweets to show.");
        } else {
            allTweets.forEach(TweetController::displayTweet);
        }
    }

    public void viewTweetsOfUsers(UserDetails user) throws NumberFormatException, IOException {
        OnScreenMessages.showDisplayMessage("Tweets Of User");
        List<UserDetails> allUsers = userService.getAllUsers();
        int ch = 1;
        for (UserDetails u : allUsers) {
            System.out.println(ch + ") " + u.getEmail());
            ch++;
        }
        System.out.print("Enter Your Choice: ");
        int userChoice = 0;
        try {
            userChoice = Integer.parseInt(CmdLineInputs.readInput());
        } catch (NumberFormatException ex) {
            OnScreenMessages.showMessage("ERROR! Please Enter Correct Choice");
        }
        if (userChoice > 0 && userChoice <= allUsers.size()) {
            userChoice--;
            List<Tweet> userTweets = tweetService.getTweetsByEmail(allUsers.get(userChoice).getEmail());
            System.out.println();
            if (userTweets.isEmpty()) {
                OnScreenMessages.showMessage("No Tweets to show.");
            } else {
                OnScreenMessages.showMessage("Tweets of " + allUsers.get(userChoice).getEmail());
                userTweets.forEach(TweetController::displayTweet);
            }
        } else {
            OnScreenMessages.showMessage("Please Enter Correct Choice");
        }
    }
}
