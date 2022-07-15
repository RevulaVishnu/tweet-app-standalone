package com.tweetapp.tweetconsoleapp.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parse(String dateString) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
    }

}
