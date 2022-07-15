package com.tweetapp.tweetconsoleapp.util;

import com.tweetapp.tweetconsoleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {


    private UserValidator(){
        throw new IllegalStateException("Utility class");
    }

    public static List<String> validate(String firstName, String lastName, String gender, String dob, String email,
                                        String password, String mobileNumber) {
        List<String> errors = new ArrayList<>();
        String message;

        // First Name
        if (firstName.equals("")) {
            message = "First Name cannot be empty";
            errors.add(message);
        }
        if (firstName.length() > 30) {
            message = "First Name cannot be more than 30 characters";
            errors.add(message);
        }

        // Last Name
        if (lastName.length() > 30) {
            message = "Last Name cannot be more than 30 characters";
            errors.add(message);
        }

        // Gender
        if (gender.equals("")) {
            message = "Gender cannot be empty";
            errors.add(message);
        }
        if (!(gender.equals("male") || gender.equals("female"))) {
            message = "Gender can be either [male/female] only";
            errors.add(message);
        }
        try {
            DateUtil.parse(dob);
        } catch (ParseException e) {
            message = "Date Format [" + dob + "] is Invalid. Example Format: [26-09-1980]";
            errors.add(message);
        }

        // Email
        if (email.equals("")) {
            message = "Email cannot be empty";
            errors.add(message);
        }
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            message = "Email Format [" + email + "] is Invalid. Example Format: [name@example.com]";
            errors.add(message);
        }
        if (email.length() > 50) {
            message = "Email cannot be more than 50 characters";
            errors.add(message);
        }

        // Password
        if (password.equals("")) {
            message = "Password cannot be empty";
            errors.add(message);
        }
        if (password.length() > 30) {
            message = "Password cannot be more than 30 characters";
            errors.add(message);
        }

        return errors;
    }

    public static List<String> validate(String password, String confirmPassword) {
        List<String> errors = new ArrayList<>();
        String message;

        // Password
        if (password.equals("")) {
            message = "Password cannot be empty";
            errors.add(message);
        }
        if (password.length() > 30) {
            message = "Password cannot be more than 30 characters";
            errors.add(message);
        }

        // Confirm Password
        if (confirmPassword.equals("")) {
            message = "Confirm Password cannot be empty";
            errors.add(message);
        }
        if (confirmPassword.length() > 30) {
            message = "Confirm Password cannot be more than 30 characters";
            errors.add(message);
        }
        if (!password.equals(confirmPassword)) {
            message = "Password and Confirm Password doesn't match";
            errors.add(message);
        }

        return errors;
    }

}
