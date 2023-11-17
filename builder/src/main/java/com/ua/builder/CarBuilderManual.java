package com.ua.builder;

public class CarBuilderManual
        implements BuilderManual {

    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Long price;
    private boolean gps;
    private boolean climateControl;

    @Override
    public CarBuilderManual color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public BuilderManual model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public BuilderManual year(Integer year) {
        this.year = year;
        return this;
    }

    @Override
    public BuilderManual brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public BuilderManual price(Long price) {
        this.price = price;
        return this;
    }

    @Override
    public BuilderManual gps(boolean gps) {
        this.gps = gps;
        return this;
    }

    @Override
    public BuilderManual climateControl(boolean climate) {
        this.climateControl = climate;
        return this;
    }

    @Override
    public Car build() {
        return new Car(brand,
                       model,
                       year,
                       color,
                       price,
                       gps,
                       climateControl);
    }
}
