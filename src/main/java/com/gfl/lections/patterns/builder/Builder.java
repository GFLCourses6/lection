package com.gfl.lections.patterns.builder;

public interface Builder {
    void setBrand(String brand);
    void setModel(String model);
    void setYear(Integer year);
    void setColor(String color);
    void setGPS(String gps);
    void setCruiseControl(String cruiseControl);
}
