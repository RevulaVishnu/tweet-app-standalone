package com.tweetapp.tweetconsoleapp.controller;

import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.service.UserService;
import com.tweetapp.tweetconsoleapp.util.CmdLineInputs;
import com.tweetapp.tweetconsoleapp.util.DateUtil;
import com.tweetapp.tweetconsoleapp.util.OnScreenMessages;
import com.tweetapp.tweetconsoleapp.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AppHomeController appHomeController;
    @Autowired
    TweetController tweetController;


    public void registerUser() throws IOException {
        OnScreenMessages.showDisplayMessage("User Registration Form:");
        String email;
        String password;
        String firstName;
        String lastName;
        String gender;
        String dob;
        String mobileNumber;

        System.out.print("\t\tEnter First Name(Required): ");
        firstName = CmdLineInputs.readInput();
        System.out.print("\t\tEnter Last Name(Optional): ");
        lastName = CmdLineInputs.readInput();
        System.out.print("\t\tEnter Gender(Required) [male/female]: ");
        gender = CmdLineInputs.readInput().toLowerCase();
        System.out.print("\t\tEnter Date of Birth(Optional) [dd-MM-yyyy]: ");
        dob = CmdLineInputs.readInput();
        System.out.print("\t\tEnter Email(Required): ");
        email = CmdLineInputs.readInput();
        System.out.print("\t\tEnter Password(Required): ");
        password = CmdLineInputs.readInput();
        System.out.print("\t\tEnter Mobile Number(Required): ");
        mobileNumber = CmdLineInputs.readInput();
        int i;
        for(i=0;i<3;i++){
            if (userService.emailAlreadyExist(email)) {
                String message = "Email " + email + " already exist in the Database";
                OnScreenMessages.showMessage("Please enter a different email id");
                System.out.println("\t\tERROR -> " + message);
                continue;
            }

            List<String> validationErrors = UserValidator.validate(firstName, lastName, gender, dob, email, password, mobileNumber);
            if (validationErrors.isEmpty()) {
                try {
                    UserDetails user = new UserDetails(email, password, firstName, lastName, gender, DateUtil.parse(dob), mobileNumber,false);
                    if (userService.registerUser(user) != null) {
                        OnScreenMessages.showMessage("User Registration Successful.");
                        loginUser();
                    } else {
                        OnScreenMessages.showMessage("User Registration Failed!");
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid Date Format");
                }
                break;
            } else {
                OnScreenMessages.showMessage("Invalid Details!");
                validationErrors.forEach(error -> System.out.println("\t\tERROR -> " + error));
                OnScreenMessages.showDisplayMessage("Please enter valid registration details");
                registerUser();
            }
        }
        if(i==3){
            OnScreenMessages.showMessage("Regestration failed");
            OnScreenMessages.showMessage("Please restart the app");

        }
    }

    public void loginUser() throws IOException {
        String email;
        String password;
        OnScreenMessages.showDisplayMessage("User Login Form:");
        System.out.print("\t\tEnter Email: ");
        email = CmdLineInputs.readInput();
        System.out.print("\t\tEnter Password: ");
        password = CmdLineInputs.readInput();
        UserDetails user = userService.checkUserCredentials(email, password);
        if (Objects.isNull(user)) {
            OnScreenMessages.showMessage("Incorrect Username or Password");
        } else {
            OnScreenMessages.showMessage("User Logged in Successfully.");
            userService.updateLoginStatus(user,true);
            processLoggedInUser(user);
        }
    }

    public void resetPassword() throws IOException {
        OnScreenMessages.showDisplayMessage("Reset Password Form:");
        System.out.print("\t\tEnter your Email to Reset Password: ");
        String email = CmdLineInputs.readInput();
        if (userService.emailAlreadyExist(email)) {
            System.out.print("\t\tEnter New Password: ");
            String password = CmdLineInputs.readInput();
            System.out.print("\t\tConfirm Password: ");
            String confirmPassword = CmdLineInputs.readInput();

            List<String> validationErrors = UserValidator.validate(password, confirmPassword);
            if (validationErrors.isEmpty()) {
                UserDetails user = userService.getUserByEmail(email);
                if (userService.updateUserPassword(user, password)!=null) {
                    OnScreenMessages.showMessage("Password Updated Successfully.");
                } else {
                    OnScreenMessages.showMessage("Unable to Reset Password.");
                }
            } else {
                OnScreenMessages.showMessage("Validation Failed!");
                validationErrors.forEach(error -> System.out.println("\t\tERROR -> " + error));
            }
        } else {
            OnScreenMessages.showMessage("Email doesn't exist in Database.");
        }
        
    }

    public void resetPassword(UserDetails userDetails) throws IOException {
        OnScreenMessages.showDisplayMessage("Reset Password Form:");
        System.out.print("\t\tEnter your Email to Reset Password: ");
        String email = CmdLineInputs.readInput();
        if (userService.emailAlreadyExist(email)) {
            System.out.print("\t\tEnter New Password: ");
            String password = CmdLineInputs.readInput();
            System.out.print("\t\tConfirm Password: ");
            String confirmPassword = CmdLineInputs.readInput();

            List<String> validationErrors = UserValidator.validate(password, confirmPassword);
            if (validationErrors.isEmpty()) {
                UserDetails user = userService.getUserByEmail(email);
                if (userService.updateUserPassword(user, password)!=null) {
                    OnScreenMessages.showMessage("Password Updated Successfully.");
                } else {
                    OnScreenMessages.showMessage("Unable to Reset Password.");
                }
            } else {
                OnScreenMessages.showMessage("Validation Failed!");
                validationErrors.forEach(error -> System.out.println("\t\tERROR -> " + error));
            }
        } else {
            OnScreenMessages.showMessage("Email doesn't exist in Database.");
        }
        
    }

    private void processLoggedInUser(UserDetails user) throws IOException {
        int choice;
        do {
            OnScreenMessages.showDisplayMessage("Logged In as " + user.getEmail());
            OnScreenMessages.showloggedInOptions();
            try {
                choice = Integer.parseInt(CmdLineInputs.readInput());
            } catch (NumberFormatException ex) {
                OnScreenMessages.showMessage("ERROR! Please Enter Correct Choice");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println();
                    tweetController.postTweet(user);
                    break;
                case 2:
                    System.out.println();
                    tweetController.viewMyTweets(user);
                    break;
                case 3:
                    System.out.println();
                    tweetController.viewAllTweets();
                    break;
                case 4:
                    System.out.println();
                    tweetController.viewTweetsOfUsers(user);
                    break;
                case 5:
                    System.out.println();
                    resetPassword(user);
                    break;
                case 6:
                    System.out.println();
                    userService.updateLoginStatus(user, false);
                    OnScreenMessages.showMessage("Logged out successfully.");
                    appHomeController.launchApp();
                    break;
                default:
                    OnScreenMessages.showMessage("ERROR! Please Enter Correct Choice");
                    break;
            }
        } while (choice != 6);
        
    }
}
