package com.codecool.testautomation.utils;

import java.util.Objects;

public class Utils {
    public static String getEnvironmentVariable(String variable) {
        return System.getenv(variable);
    }
    public static String nullToEmptyString(String string) {
        return Objects.requireNonNullElse(string, "");
    }
}
