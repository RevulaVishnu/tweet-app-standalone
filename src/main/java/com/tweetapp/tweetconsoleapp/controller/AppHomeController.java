package com.tweetapp.tweetconsoleapp.controller;

import com.tweetapp.tweetconsoleapp.util.CommandLineInputs;
import com.tweetapp.tweetconsoleapp.util.OnScreenMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class AppHomeController {
    @Autowired
    UserController userController;

    public void launchApp() throws IOException {
        int choice;
        OnScreenMessages.mainHeader("Welcome to Tweet App");
        int i=0;
        while(i<3) {
            OnScreenMessages.appHomeMenu();
            try {
                choice = Integer.parseInt(CommandLineInputs.readInput());
                switch (choice) {
                    case 1 -> {
                        System.out.println();
                        userController.registerUser();
                    }
                    case 2 -> {
                        System.out.println();
                        userController.loginUser();
                    }
                    case 3 -> {
                        System.out.println();
                        userController.resetPassword();
                    }
                    case 4 -> {
                        System.out.println();
                        exitApp();
                    }
                    default -> throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | ParseException ex) {
                OnScreenMessages.showMessage("ERROR! Please Enter Correct Choice");
            }
            i++;
        }
    }
    public void exitApp() throws IOException {
        OnScreenMessages.showMessage("Thank You for Using Tweet App.");
        CommandLineInputs.closeBr();
        System.exit(1);
    }
}
