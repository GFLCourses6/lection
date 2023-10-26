package com.classwork.pattern.builder;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Long price;
    private boolean gps;
    private boolean climateControl;

    public Car() {
    }

    public Car(
            String brand, String model, int year, String color, long price,
            boolean gps, boolean climateControl) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.gps = gps;
        this.climateControl = climateControl;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isGps() {
        return gps;
    }

    public boolean isClimateControl() {
        return climateControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year.equals(car.year)
                && price.equals(car.price)
                && gps == car.gps
                && climateControl == car.climateControl
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                brand, model, year, color, price, gps, climateControl);
    }

    @Override
    public String toString() {
        return String.format(
                "Car{brand='%s', model='%s', year=%d, color='%s', price=%d, gps=%s, climateControl=%s}%n",
                brand, model, year, color, price, gps, climateControl);
    }
}
