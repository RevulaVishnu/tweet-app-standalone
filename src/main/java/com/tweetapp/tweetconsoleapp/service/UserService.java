package com.tweetapp.tweetconsoleapp.service;

import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDetails checkUserCredentials(String email, String password) {
        Optional<UserDetails> userOptional = userRepository.findById(email);
        if (userOptional.isPresent()) {
            UserDetails userDetails = userOptional.get();
            if (password.equals(userDetails.getPassword())) {
                return userDetails;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public UserDetails registerUser(UserDetails userDetails) {
        return  userRepository.save(userDetails);
    }

    public boolean emailAlreadyExist(String email) {
        Optional<UserDetails> userOptional = userRepository.findById(email);
        return userOptional.isPresent();
    }

    public UserDetails getUserByEmail(String email) {
        Optional<UserDetails> userOptional = userRepository.findById(email);
        UserDetails userDetails = null;
        if (userOptional.isPresent()) {
            userDetails = userOptional.get();
        }
        return userDetails;
    }

    public UserDetails updateUserPassword(UserDetails userDetails, String password) {
        userDetails.setPassword(password);
        return userRepository.save(userDetails);
    }

    public List<UserDetails> getAllUsers() {
        return userRepository.findAll();
    }

}
