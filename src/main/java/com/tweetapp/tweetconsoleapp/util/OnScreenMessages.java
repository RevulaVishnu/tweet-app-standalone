package com.tweetapp.tweetconsoleapp.util;

public class OnScreenMessages {
    public static void showDisplayMessage(String string) {
        System.out.println("****************************************************************************************");
        System.out.println("\t\t\t\t" + string + "");
        System.out.println("****************************************************************************************");
    }

    public static void showMessage(String string) {
        System.out.println();
        System.out.println("\t\t\t" + string + "");
        System.out.println();
    }

    public static void appHomeMenu() {
        System.out.println("1) Register");
        System.out.println("2) Login");
        System.out.println("3) Forgot Password");
        System.out.println("4) Exit");
        System.out.print("Enter Your Choice: ");
    }

    public static void showloggedInOptions() {
        System.out.println("1) Post a Tweet");
        System.out.println("2) View my Tweets");
        System.out.println("3) View all Tweets");
        System.out.println("4) View Tweets of users");
        System.out.println("5) Change Password");
        System.out.println("6) Logout");
        System.out.print("Enter Your Choice: ");
    }
}
