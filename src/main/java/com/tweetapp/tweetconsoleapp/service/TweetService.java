package com.tweetapp.tweetconsoleapp.service;

import com.tweetapp.tweetconsoleapp.model.Tweet;
import com.tweetapp.tweetconsoleapp.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TweetService {
    @Autowired
    TweetRepository tweetRepository;
    public void postTweet(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    public List<Tweet> getTweetsByEmail(String email) {
        return tweetRepository.findAllById(Collections.singleton(email));
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

}
