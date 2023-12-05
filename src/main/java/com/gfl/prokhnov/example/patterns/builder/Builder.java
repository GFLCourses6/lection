package com.gfl.prokhnov.example.patterns.builder;

public interface Builder {
    void setColor(String color);

    void setModel(String model);

    void setYear(Integer year);

    void setBrand(String brand);

    void setGps(String gps);

    void setClimateControl(String climateControl);
}
