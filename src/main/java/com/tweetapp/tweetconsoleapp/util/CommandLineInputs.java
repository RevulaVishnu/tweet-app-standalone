package com.tweetapp.tweetconsoleapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Objects;

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

//    public static getDetailsFromCSV<T>(T t) {
//
//        String line = "";
//        BufferedReader fileReader = new BufferedReader(
//                new InputStreamReader(Objects.requireNonNull(this.getClass().getResourceAsStream("/userDetails.csv"))));
//        try {
//            while ((line = fileReader.readLine()) != null) // returns a Boolean value
//            {
//                String[] pensionerDetail = line.split(",");
//
//                if (aadhaarNumber.contentEquals(pensionerDetail[0])) {
////                    log.info("Details found");
//                    return new PensionerDetails
//                            (
//                                    pensionerDetail[1],
//                                    pensionerDetail[0],
//                                    DateUtil.parseDate(pensionerDetail[2]),
//                                    pensionerDetail[3],
//                                    Double.parseDouble(pensionerDetail[4]),
//                                    Double.parseDouble(pensionerDetail[5]),
//                                    pensionerDetail[6],
//                                    Long.parseLong(pensionerDetail[8]),
//                                    new BankDetails(
//                                            pensionerDetail[7],
//                                            Long.parseLong(pensionerDetail[8]),
//                                            pensionerDetail[9]
//                                    )
//                            );
//                }
//            }
//        } catch (NumberFormatException | IOException | ParseException e) {
//            throw new NotFoundException(AADHAAR_NUMBER_NOT_FOUND);
//        }
//        throw new NotFoundException(AADHAAR_NUMBER_NOT_FOUND);
//    }

}
