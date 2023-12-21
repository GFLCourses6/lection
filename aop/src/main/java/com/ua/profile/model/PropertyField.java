package com.ua.profile.model;

public class PropertyField {

    private String number;
    private String port;

    public PropertyField(
            String number,
            String port) {
        this.number = number;
        this.port = port;
    }

    public String getNumber() {
        return number;
    }

    public String getPort() {
        return port;
    }
}
