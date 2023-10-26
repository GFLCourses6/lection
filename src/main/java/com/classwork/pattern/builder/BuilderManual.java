package com.classwork.pattern.builder;

public interface BuilderManual {
    BuilderManual color(String color);
    BuilderManual model(String model);
    BuilderManual year(Integer year);
    BuilderManual brand(String brand);
    BuilderManual price(Long price);
    BuilderManual gps(boolean gps);
    BuilderManual climateControl(boolean climate);
    Car build();
}
