package Hacker_Rank;


import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 *
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 *
 * Example
 *  s = "12:01:00PM"
 *
 * Return '12:01:00'.
 *
 *  s = '12:01:00AM'
 * Return '00:01:00'.
 * */

public class Time_Conversion {

    public static void main(String[] args) {

        String result = timeConversion("12:01:00PM");
        System.out.println(result);

    }

    public static String timeConversion(String s) {

        String time = s.substring(0, s.length()-2);
        String amPm = s.substring(s.length() - 2, s.length());
        String[] timeArr = time.split(":");
        String hour = timeArr[0];
        int hourNum = Integer.parseInt(hour) % 12;
        if(amPm.equals("PM")) {
            hourNum = hourNum + 12;
        }
        String hourString = Integer.toString(hourNum);
        if(hourString.length() == 1) hourString = "0"+hourString;

        return hourString+":"+timeArr[1]+":"+timeArr[2];
    }
}
