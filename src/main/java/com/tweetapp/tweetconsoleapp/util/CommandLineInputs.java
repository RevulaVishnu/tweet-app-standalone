package com.tweetapp.tweetconsoleapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineInputs {

    private CommandLineInputs() {
        throw new IllegalStateException("Utility class");
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String readInput() throws IOException {
       return br.readLine().trim();
    }

    public static void closeBr() throws IOException {
        OnScreenMessages.showMessage("Closing reader");
        br.close();
    }
}
