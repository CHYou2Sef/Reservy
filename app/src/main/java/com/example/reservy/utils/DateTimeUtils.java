package com.example.reservy.utils;

public class DateTimeUtils {
    public static final String DATE_FORMAT = "dd MMMM yyyy";
    public static String formatSpectacleDateTime(String dateS, String hDebutS) {
        return String.format("%s, %s", dateS, hDebutS);

    }
}
