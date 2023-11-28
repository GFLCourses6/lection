package com.vladproduction.services;

public class StringIntegrationServiceImpl implements StringIntegrationService {
    @Override
    public String parsStringByRegex(String str) {
        String[] parsedStringArray = str.split(";");
        String parsedString = String.join("", parsedStringArray);
        System.out.println(parsedString);
        return parsedString;
    }
}
