package com.ua.builder;

public class CarBuilder
        implements Builder {

    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Long price;
    private boolean gps;
    private boolean climateControl;

    @Override
    public void color(String color) {
        this.color = color;
    }

    @Override
    public void model(String model) {
        this.model = model;
    }

    @Override
    public void year(Integer year) {
        this.year = year;
    }

    @Override
    public void brand(String brand) {
        this.brand = brand;
    }

    @Override
    public void price(Long price) {
        this.price = price;
    }

    @Override
    public void gps(boolean gps) {
        this.gps = gps;
    }

    @Override
    public void climateControl(boolean climate) {
        this.climateControl = climate;
    }

    @Override
    public void print() {
        System.out.printf(
                "Car{brand='%s', model='%s', year=%d, color='%s', price=%d, gps=%s, climateControl=%s}%n",
                brand, model, year, color, price, gps, climateControl);
    }

    @Override
    public Car build() {
        return new Car(brand, model, year, color, price, gps, climateControl);
    }
}
