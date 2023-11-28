package org.example.di.service;

public class StringIntegrationServiceImpl implements StringIntegrationService {
    @Override
    public String parseStingByRegex(String str) {
        String[] parsedStringArray = str.split(";");
        String parsedString = String.join("", parsedStringArray);
        System.out.println(parsedString);
        return parsedString;
    }
}
