package com.gfl.prokhnov.example.patterns.di.service;

public class StringIntegrationServiceImpl implements StringIntegrationService {
    @Override
    public String parseStringByRegex(String str) {
        String[] parsedStringArray = str.split(";");
        String parsedString = String.join("", parsedStringArray);
        System.out.println(parsedString);
        return parsedString;
    }
}
