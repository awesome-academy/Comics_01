package com.sun_asterisk.comics_01.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public final static String DIVISION_CHARACTER = "T";
    public final static String SEPARATE_COMMA = ",";
    public final static String SEPARATE_SPACE = " ";
    public final static String SEPARATE_DOLLAR = "@@";

    public static String formatDate(String date) {
        int endIndex = date.indexOf(DIVISION_CHARACTER);
        return date.substring(0, endIndex);
    }

    public static List<String> formatStrToStrUrls(String data) {
        String[] arrayStrUrls = data.split(SEPARATE_COMMA);
        return Arrays.asList(arrayStrUrls);
    }
}
