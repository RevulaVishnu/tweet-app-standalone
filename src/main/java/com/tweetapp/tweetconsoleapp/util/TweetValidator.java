package com.tweetapp.tweetconsoleapp.util;

import com.tweetapp.tweetconsoleapp.controller.TweetController;

import java.util.ArrayList;
import java.util.List;

public class TweetValidator {

    private TweetValidator(){
        throw new IllegalStateException("Utility class");
    }

    public static List<String> validate(String tweet) {
        List<String> errors = new ArrayList<>();
        String message;

        if (tweet.equals("")) {
            message = "Tweet cannot be empty";
            errors.add(message);
        }
        if (tweet.length() > 300) {
            message = "Tweet cannot be more than 300 characters";
            errors.add(message);
        }
        return errors;
    }

}
