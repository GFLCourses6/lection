package org.example.builder;


public class CarBuilderDirector {

    public void constructSportsCar(Builder builder) {
        builder.color("Red");
        builder.brand("Maserati");
        builder.model("Levante");
        builder.price(200000L);
        builder.year(2023);
        builder.gps("Basic GPS");
        builder.hasClimateControl(true);
        builder.gps("Modern GPS");
        builder.engineType("V8");
        builder.fuelType("Diesel");
    }

    public void constructBusiness(Builder builder) {
        builder.color("Blue");
        builder.brand("Mercedes-Benz");
        builder.model("E-Class");
        builder.price(60000L);
        builder.year(2023);
        builder.hasClimateControl(true);
        builder.gps("Modern GPS");
        builder.engineType("V8");
        builder.fuelType("Petrol");
    }

    public void constructBasic(Builder builder) {
        builder.color("Gray");
        builder.brand("Toyota");
        builder.model("Corolla");
        builder.price(25000L);
        builder.year(2023);
        builder.engineType("V12");
        builder.fuelType("Diesel");
    }
}