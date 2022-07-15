package com.tweetapp.tweetconsoleapp.util;

public class OnScreenMessages {

    private OnScreenMessages() {
        throw new IllegalStateException("Utility class");
    }

    public static void mainHeader(String string) {
        System.out.println("________________________________________________________________________________________");
        System.out.println("\t\t\t\t" + string + "");
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public static void showMessage(String string) {
        System.out.println();
        System.out.println("\t" + string + "");
        System.out.println();
    }

    public static void appHomeMenu() {
        System.out.println("1) Register");
        System.out.println("2) Login");
        System.out.println("3) Forgot Password");
        System.out.println("4) Exit");
        System.out.println();
        System.out.print("Enter Your Choice: ");
    }

    public static void optionsAfterLogin() {
        System.out.println("1) Post a Tweet");
        System.out.println("2) View my Tweets");
        System.out.println("3) View all Tweets");
        System.out.println("4) View Tweets of users");
        System.out.println("5) Change Password");
        System.out.println("6) Logout");
        System.out.print("Enter Your Choice: ");
    }
}
