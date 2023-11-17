package org.example.builder;

public interface Builder {
    void color(String color);
    void model(String model);
    void year(Integer year);
    void brand(String brand);
    void price(Long price);
    void gps(String gps);
    void hasClimateControl(boolean climate);
    void engineType(String engineType);
    void fuelType(String fuelType);
    void print();
    Car build();
}