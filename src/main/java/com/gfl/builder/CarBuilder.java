package com.gfl.builder;

import com.gfl.builder.model.Car;

public class CarBuilder implements Builder{
    private String color;
    private String model;
    private Integer year;
    private String brand;
    private String artificialIntelligence;
    private String gps;


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
    public void setArtificialIntelligence(String artificialIntelligence) {
        this.artificialIntelligence = artificialIntelligence;
    }

    @Override
    public void setGps(String gps) {
        this.gps = gps;
    }

    public Car getCar() {
        return new Car(color, model, year, brand, gps, artificialIntelligence);
    }

}
