package com.eden.d.moss.scraper;

public final class Util {
    private static final String NUMERIC_REGEX_PATTERN = "-?\\d+(\\.\\d+)?";

    private Util() {

    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches(NUMERIC_REGEX_PATTERN);
    }
}
