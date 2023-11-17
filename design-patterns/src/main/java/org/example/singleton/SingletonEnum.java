package org.example.singleton;

public enum SingletonEnum {
    INSTANCE("INITIAL");
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

}
