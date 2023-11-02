package com.gfl.lections.patterns.builder;

public class CarBuilderManual implements Builder {
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

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Brand - %s, model - %s, year - %s, color - %s", brand, model, year, color));
        if (gps != null) {
            builder.append(String.format(", gps - %s", gps));
        }
        if (cruiseControl != null) {
            builder.append(String.format(", cruise control - %s", cruiseControl));
        }
        System.out.println(builder);
    }
}
