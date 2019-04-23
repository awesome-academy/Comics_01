package com.sun_asterisk.comics_01.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public final static String DIVISION_CHARACTER = "T";
    public final static String SEPARATE_IMG_LINK = ",";
    public final static String SEPARATE_AUTHOR = " ";

    public static String formatDate(String date) {
        int endIndex = date.indexOf(DIVISION_CHARACTER);
        return date.substring(0, endIndex);
    }

    public static List<String> formatStrToStrUrls(String data) {
        String[] arrayStrUrls = data.split(SEPARATE_IMG_LINK);
        return Arrays.asList(arrayStrUrls);
    }
}
