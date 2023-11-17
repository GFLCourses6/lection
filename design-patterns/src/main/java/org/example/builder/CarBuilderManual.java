package org.example.builder;

public class CarBuilderManual implements BuilderManual{
    private String brand;
    private String model;
    private String color;
    private Long price;
    private Integer year;
    private String gps;
    private boolean hasClimateControl;
    private String engineType;
    private String fuelType;

    @Override
    public BuilderManual color(String color) {
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
    public BuilderManual gps(String gps) {
        this.gps = gps;
        return this;
    }


    @Override
    public BuilderManual hasClimateControl(boolean climate) {
        this.hasClimateControl = climate;
        return this;
    }

    @Override
    public BuilderManual engineType(String engineType) {
        this.engineType = engineType;
        return this;
    }
    @Override
    public BuilderManual fuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }


    @Override
    public Car build() {
        return new Car(brand,
                model,
                color,
                price,
                year,
                gps,
                hasClimateControl,
                engineType,
                fuelType);
    }

    @Override
    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Brand - %s, model - %s, year - %s, color - %s", brand, model, year, color));
        if (gps != null) {
            builder.append(String.format(", gps - %s", gps));
        }
        if (hasClimateControl) {
            builder.append(String.format(", climate control - %s", hasClimateControl));
        }
        System.out.println(builder);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Car{")
                .append("brand='").append(brand).append('\'')
                .append(", model='").append(model).append('\'')
                .append(", color='").append(color).append('\'')
                .append(", price=").append(price).append('\'')
                .append(", year=").append(year).append('\'')
                .append(", gps='").append(gps).append('\'')
                .append(", hasClimateControl=").append(hasClimateControl).append('\'')
                .append(", engineType=").append(engineType).append('\'')
                .append(", fuelType=").append(fuelType)
                .append('}').toString();
    }
}
