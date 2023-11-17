package org.example.builder;

public interface BuilderManual {
    BuilderManual color(String color);
    BuilderManual model(String model);
    BuilderManual year(Integer year);
    BuilderManual brand(String brand);
    BuilderManual price(Long price);
    BuilderManual gps(String gps);
    BuilderManual hasClimateControl(boolean climate);
    BuilderManual engineType(String engineType);
    BuilderManual fuelType(String fuelType);
    Car build();
    void print();
}
