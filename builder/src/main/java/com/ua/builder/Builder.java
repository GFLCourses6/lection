package com.ua.builder;

public interface Builder {

    void color(String color);
    void model(String model);
    void year(Integer year);
    void brand(String brand);
    void price(Long price);
    void gps(boolean gps);
    void climateControl(boolean climate);
    void print();
    Car build();
}
