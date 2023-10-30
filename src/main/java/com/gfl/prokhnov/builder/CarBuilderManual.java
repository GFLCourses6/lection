package com.gfl.prokhnov.builder;

public class CarBuilderManual implements Builder {

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

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Car color - %s; Model - %s; Year - %s; Brand - %s;", color, model, year, brand));

        if (gps != null){
            builder.append(String.format(" GPS - %s;", gps));
        }

        if (climateControl != null){
            builder.append(String.format(" Climate control - %s;", climateControl));
        }

        System.out.println(builder);

    }
}
