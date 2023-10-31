package com.vladproduction.app07;

public enum SingletonD {
    INSTANCE;
    private String url;

    SingletonD(){
        System.out.println("SingletonD() constructor invoke now");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "url=" + url;
    }
}
