package com.gfl.prokhnov.builder;

public class Car {
    private String color;
    private String model;
    private Integer year;
    private String brand;
    private String gps;
    private String climateControl;

    public Car() {
    }

    public Car(String color, String model, Integer year, String brand, String gps, String climateControl) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.brand = brand;
        this.gps = gps;
        this.climateControl = climateControl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getClimateControl() {
        return climateControl;
    }

    public void setClimateControl(String climateControl) {
        this.climateControl = climateControl;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", gps='" + gps + '\'' +
                ", climateControl='" + climateControl + '\'' +
                '}';
    }
}
