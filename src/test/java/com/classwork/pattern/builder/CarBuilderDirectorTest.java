package com.classwork.pattern.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarBuilderDirectorTest {

    @Test
    void testConstructSportsCar() {
        Builder builder = new CarBuilder();
        CarBuilderDirector director = new CarBuilderDirector();

        director.constructSportsCar(builder);
        Car car = builder.build();

        assertNotNull(car);
        assertEquals("Red", car.getColor());
        assertEquals("Ferrari", car.getBrand());
        assertEquals("Enzo", car.getModel());
        assertEquals(200000L, car.getPrice());
        assertEquals(2023, car.getYear());
        assertTrue(car.isGps());
    }

    @Test
    void testConstructComfortCar() {
        Builder builder = new CarBuilder();
        CarBuilderDirector director = new CarBuilderDirector();

        director.constructComfort(builder);
        Car car = builder.build();

        assertNotNull(car);
        assertEquals("Blue", car.getColor());
        assertEquals("Mercedes-Benz", car.getBrand());
        assertEquals("E-Class", car.getModel());
        assertEquals(60000L, car.getPrice());
        assertEquals(2023, car.getYear());
        assertTrue(car.isClimateControl());
        assertTrue(car.isGps());
    }

    @Test
    void testConstructBasicCar() {
        Builder builder = new CarBuilder();
        CarBuilderDirector director = new CarBuilderDirector();

        director.constructBasic(builder);
        Car car = builder.build();

        assertNotNull(car);
        assertEquals("Gray", car.getColor());
        assertEquals("Toyota", car.getBrand());
        assertEquals("Corolla", car.getModel());
        assertEquals(25000L, car.getPrice());
        assertEquals(2023, car.getYear());
        assertFalse(car.isGps());
        assertFalse(car.isClimateControl());
    }

    @Test
    void testEqualsAndHashCodeCarBuilder() {
        CarBuilder carBuilder = new CarBuilder();
        String brand = "Toyota";
        String model = "Camry";
        Integer year = 2020;
        String color = "Black";
        Long price = 30000L;
        boolean gps = true;
        boolean climateControl = true;

        carBuilder.brand(brand);
        carBuilder.model(model);
        carBuilder.year(year);
        carBuilder.color(color);
        carBuilder.price(price);
        carBuilder.gps(gps);
        carBuilder.climateControl(climateControl);
        Car car = carBuilder.build();

        BuilderManual builder = new CarBuilderManual();

        Car carManual = builder
                .color(color)
                .model(model)
                .year(year)
                .brand(brand)
                .price(price)
                .climateControl(climateControl)
                .gps(gps)
                .build();

        assertEquals(car, carManual);
        assertEquals(car.hashCode(), carManual.hashCode());
    }
}
