package com.zenika.date;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class MainDate {

    public static void main(String[] args) {
        System.out.println("getMonthLengthForYear");
        getMonthLengthForYear(args);

        System.out.println("");

        System.out.println("getAllMondaysForMonth");
        getAllMondaysForMonth(args);
    }

    // Write an example that, for a given year, reports the length of each month within that year.
    public static void getMonthLengthForYear(String []args) {
        if (args == null || args.length == 0) {
            throw new RuntimeException("Missing arguments");
        }

        int givenYear = 0;

        try {
            givenYear = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new  RuntimeException("Invalid year");
        }

        final Year year = Year.of(givenYear);

        System.out.println("Length of month for the year : " + givenYear);
        for (int i = 1; i < 13; i++) {
            System.out.println(year.atMonth(i).getMonth().name() + " : " + year.atMonth(i).lengthOfMonth());
        }
    }

    // Write an example that, for a given month of the current year, lists all of the Mondays in that month.
    public static void getAllMondaysForMonth(String []args) {
        if (args == null || args.length < 1) {
            throw new RuntimeException("Missing arguments");
        }

        int givenMonth = 0;

        try {
            givenMonth = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new  RuntimeException("Invalid month");
        }

        Month month = Month.of(givenMonth);

        LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));


        while (date.getMonth() == month) {
            System.out.println(date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        }
    }
}