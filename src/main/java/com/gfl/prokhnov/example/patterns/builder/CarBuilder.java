package com.gfl.prokhnov.example.patterns.builder;

public class CarBuilder implements Builder {
    private String color;
    private String model;
    private Integer year;
    private String brand;
    private String gps;
    private String climateControl;

    @Override
    public void setColor(String color) {
        this.color = color;

    }

    @Override
    public void setModel(String model) {
        this.model = model;

    }

    @Override
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setGps(String gps) {
        this.gps = gps;
    }

    @Override
    public void setClimateControl(String climateControl) {
        this.climateControl = climateControl;
    }

    public Car getCar() {
        return new Car(color, model, year, brand, gps, climateControl);
    }
}
