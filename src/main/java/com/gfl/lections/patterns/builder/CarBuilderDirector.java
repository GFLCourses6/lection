package com.gfl.lections.patterns.builder;

public class CarBuilderDirector {
    public void constructBasic(Builder builder) {
        builder.setBrand("Toyota");
        builder.setModel("Corolla");
        builder.setYear(2012);
        builder.setColor("Black");
    }

    public void constructComfort(Builder builder) {
        builder.setBrand("Toyota");
        builder.setModel("Corolla");
        builder.setYear(2012);
        builder.setColor("Black");
        builder.setGPS("Yes");
    }

    public void constructComfortPlus(Builder builder) {
        builder.setBrand("Toyota");
        builder.setModel("Corolla");
        builder.setYear(2012);
        builder.setColor("Black");
        builder.setGPS("Yes");
        builder.setCruiseControl("Yes");
    }
}
