package com.gfl.singleton;

public enum SingletonEnum {
    INSTANCE("DEFAULT VALUE");

    private String value;

    SingletonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println("SingletonEnum: " + value);
    }
}
