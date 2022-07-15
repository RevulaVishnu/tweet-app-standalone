package com.tweetapp.tweetconsoleapp.util;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ReadCSVUtil {
    private ReadCSVUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String[] > getObjectsFromCSV(String filePath) throws IOException {
        List<String[] > objectArr = new ArrayList<>();
        String line = "";
        Scanner sc = new Scanner(new File(filePath));
        sc.useDelimiter("\n");   //sets the delimiter pattern

        while (sc.hasNext())  //returns a boolean value
        {
            String[] pensionerDetail = sc.next().split(",");
            objectArr.add(pensionerDetail);
        }
        sc.close();  //closes the scanner
        return objectArr;
    }
}
