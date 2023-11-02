package com.gfl.lections.patterns.builder;

public class CarBuilder implements Builder {
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String gps;
    private String cruiseControl;

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
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
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setGPS(String gps) {
        this.gps = gps;
    }

    @Override
    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public Car getCar() {
        return new Car(brand, model, year, color, gps, cruiseControl);
    }
}
