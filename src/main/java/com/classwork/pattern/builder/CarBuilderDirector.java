package com.classwork.pattern.builder;

public class CarBuilderDirector {

    public void constructSportsCar(Builder builder) {
        builder.color("Red");
        builder.brand("Ferrari");
        builder.model("Enzo");
        builder.price(200000L);
        builder.year(2023);
        builder.gps(true);
    }

    public void constructComfort(Builder builder) {
        builder.color("Blue");
        builder.brand("Mercedes-Benz");
        builder.model("E-Class");
        builder.price(60000L);
        builder.year(2023);
        builder.climateControl(true);
        builder.gps(true);
    }

    public void constructBasic(Builder builder) {
        builder.color("Gray");
        builder.brand("Toyota");
        builder.model("Corolla");
        builder.price(25000L);
        builder.year(2023);
    }
}
