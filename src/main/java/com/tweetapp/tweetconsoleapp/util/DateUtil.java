package com.tweetapp.tweetconsoleapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Date parse(String dateString) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
    }

}
