package com.classwork.pattern.di;

public class ParseService
        implements StringIntegrationService{
    @Override
    public String parseStringByRegex(String value) {
        String[] split = value.split(";");
        return String.join(" ", split);
    }
}
