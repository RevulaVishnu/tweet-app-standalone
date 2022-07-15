package com.tweetapp.tweetconsoleapp.controller;

import com.tweetapp.tweetconsoleapp.util.CmdLineInputs;
import com.tweetapp.tweetconsoleapp.util.OnScreenMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class AppHomeController {
    @Autowired
    UserController userController;

    public void launchApp() throws IOException {
        int choice;
        OnScreenMessages.showDisplayMessage("Welcome to Tweet App");
        OnScreenMessages.appHomeMenu();
        try {
            choice = Integer.parseInt(CmdLineInputs.readInput());
            switch (choice) {
                case 1:
                    System.out.println();
                    userController.registerUser();
                    break;
                case 2:
                    System.out.println();
                    userController.loginUser();
                    break;
                case 3:
                    System.out.println();
                    userController.resetPassword();
                    break;
                case 4:
                    System.out.println();
                    OnScreenMessages.showMessage("Thank You for Using Tweet App.");
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {
            OnScreenMessages.showMessage("ERROR! Please Enter Correct Choice");
        }
    }
}
