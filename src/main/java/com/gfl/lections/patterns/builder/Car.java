package com.gfl.lections.patterns.builder;

public class Car {
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String gps;
    private String cruiseControl;

    public Car() {
    }

    public Car(String brand, String model, Integer year, String color, String gps, String cruiseControl) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.gps = gps;
        this.cruiseControl = cruiseControl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", gps='" + gps + '\'' +
                ", cruiseControl='" + cruiseControl + '\'' +
                '}';
    }
}
