package com.tweetapp.tweetconsoleapp;

import com.tweetapp.tweetconsoleapp.model.UserDetails;
import com.tweetapp.tweetconsoleapp.service.UserService;
import com.tweetapp.tweetconsoleapp.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    @Autowired
    UserService userService;
    @Autowired
    UserValidator userValidator;

    private  void registerUser() throws IOException {
        
        int choice;
        do {
            showDisplayMessage("Welcome to Tweet App");
            showloggedOutOptions();
            try {
                choice = Integer.parseInt(br.readLine());
            } catch (NumberFormatException ex) {
                showMessage("ERROR! Please Enter Correct Choice");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println();
                    registerUser();
                    break;
                case 2:
                    System.out.println();
                    loginUser();
                    break;
                case 3:
                    System.out.println();
                    resetPassword();
                    break;
                case 4:
                    System.out.println();
                    showMessage("Thank You for Using Tweet App.");
                    break;
                default:
                    showMessage("ERROR! Please Enter Correct Choice");
                    break;
            }
        } while (choice != 4);
        br.close();

        showDisplayMessage("User Registration Form:");
        String firstName;
        String lastName;
        String gender;
        String dob;
        String email;
        String password;
        String confirmPassword;
        String mobileNumber;
        System.out.print("\t\tEnter First Name(Required): ");
        firstName = br.readLine().trim();
        System.out.print("\t\tEnter Last Name(Optional): ");
        lastName = br.readLine().trim();
        System.out.print("\t\tEnter Gender(Required) [male/female]: ");
        gender = br.readLine().toLowerCase().trim();
        System.out.print("\t\tEnter Date of Birth(Optional) [dd-MM-yyyy]: ");
        dob = br.readLine().trim();
        System.out.print("\t\tEnter Email(Required): ");
        email = br.readLine().trim();
        System.out.print("\t\tEnter Password(Required): ");
        password = br.readLine().trim();
        System.out.print("\t\tConfirm Password(Required): ");
        confirmPassword = br.readLine().trim();

        List<String> validationErrors = userValidator.validate(firstName, lastName, gender, dob, email, password,
                confirmPassword);
        if (validationErrors.isEmpty()) {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOfBirth = null;
            try {
                dateOfBirth = formatter.parse(dob);
            } catch (ParseException e) {
                System.out.println("Invalid Date Format");
            }
//            if (userService.registerUser(user)) {
//                showMessage("User Registration Successful.");
//            } else {
//                showMessage("User Registration Failed!");
//                throw new DatabaseException("Database Error: Unable to save to Database");
//            }
        } else {
            showMessage("Validation Failed!");
            validationErrors.forEach(error -> System.out.println("\t\tERROR -> " + error));
        }
    }

    private  void showDisplayMessage(String string) {
        System.out.println("****************************************************************************************");
        System.out.println("\t\t\t\t" + string + "");
        System.out.println("****************************************************************************************");
    }

    private  void showMessage(String string) {
        System.out.println();
        System.out.println("\t\t\t" + string + "");
        System.out.println();
    }

    private  void showloggedOutOptions() {
        System.out.println("1) Register");
        System.out.println("2) Login");
        System.out.println("3) Forgot Password");
        System.out.println("4) Exit");
        System.out.print("Enter Your Choice: ");
    }

    private  void showloggedInOptions() {
        System.out.println("1) Post a Tweet");
        System.out.println("2) View my Tweets");
        System.out.println("3) View all Tweets");
        System.out.println("4) View Tweets of users");
        System.out.println("5) Change Password");
        System.out.println("6) Logout");
        System.out.print("Enter Your Choice: ");
    }
    private  void loginUser() throws IOException {
        String email;
        String password;
        showDisplayMessage("User Login Form:");
        System.out.print("\t\tEnter Email: ");
        email = br.readLine().trim();
        System.out.print("\t\tEnter Password: ");
        password = br.readLine().trim();

        UserDetails user = userService.checkUserCredentials(email, password);
        if (Objects.isNull(user)) {
            showMessage("Incorrect Username or Password");
        } else {
            showMessage("User Logged in Successfully.");
//            userService.updateLoginStatus(user, true);
//            processLoggedInUser(user);
        }
    }

    private  void resetPassword() throws IOException {
        showDisplayMessage("Reset Password Form:");
        System.out.print("\t\tEnter your Email to Reset Password: ");
        String email = br.readLine().trim();
        if (userService.emailAlreadyExist(email)) {
            System.out.print("\t\tEnter New Password: ");
            String password = br.readLine().trim();
            System.out.print("\t\tConfirm Password: ");
            String confirmPassword = br.readLine().trim();

            List<String> validationErrors = userValidator.validate(password, confirmPassword);
            if (validationErrors.isEmpty()) {
                UserDetails user = userService.getUserByEmail(email);
                if (userService.updateUserPassword(user, password)!=null) {
                    showMessage("Password Updated Successfully.");
                } else {
                    showMessage("Unable to Reset Password.");
                }
            } else {
                showMessage("Validation Failed!");
                validationErrors.forEach(error -> System.out.println("\t\tERROR -> " + error));
            }
        } else {
            showMessage("Email doesn't exist in Database.");
        }
    }

}
