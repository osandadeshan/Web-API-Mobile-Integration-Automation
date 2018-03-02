package com.maxsoft.mobileautomation.android.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class DateTime {

    static SimpleDateFormat dateMonthYearFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    static SimpleDateFormat monthDateFormat = new SimpleDateFormat("(MMM. dd)", Locale.US);
    static String remainingDays;

    public static String getTodayDate(){
        Date date = new Date();
        String todayDate= dateMonthYearFormat.format(date);
        return todayDate;
    }

    public static String getNumberOfRemainingDays(String startingDate, String endingDate) throws ParseException {
        Date startDate = dateMonthYearFormat.parse(startingDate);
        Date endDate = dateMonthYearFormat.parse(endingDate);
            long diff = endDate.getTime() - startDate.getTime();
             remainingDays = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
                //System.out.println ("Number of remaining day/s between \"" +startingDate+ "\" and \"" +endingDate+ "\": " + remainingDays);
        return remainingDays;
    }

    public static String endDateAndMonth(String endingDate) throws ParseException {
        return monthDateFormat.format(dateMonthYearFormat.parse(endingDate));
    }

    public static String remainingDaysAndEndDateString(String startingDate, String endingDate) throws ParseException {
        int noOfDays = Integer.parseInt(getNumberOfRemainingDays(startingDate, endingDate));
        if (noOfDays == 1 || noOfDays == -1) {
            return "In "+noOfDays+" day " + endDateAndMonth(endingDate);
        } else {
            return "In " + noOfDays + " days " + endDateAndMonth(endingDate);
        }
    }


}
