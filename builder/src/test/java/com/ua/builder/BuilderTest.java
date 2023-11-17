package com.ua.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BuilderTest {

    @Test
    void testBuildSportsCar() {
        Builder builder = new CarBuilder();
        builder.color("Red");
        builder.model("Sports");
        builder.year(2023);
        builder.brand("Ferrari");
        builder.price(200000L);
        builder.gps(true);
        builder.print();
        Car car = builder.build();

        assertNotNull(car);
        assertEquals("Red", car.getColor());
        assertEquals("Sports", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals("Ferrari", car.getBrand());
        assertEquals(200000L, car.getPrice());
        assertTrue(car.isGps());
    }

    @Test
    void testBuildComfortCar() {
        Builder builder = new CarBuilder();
        builder.color("Blue");
        builder.model("Comfort");
        builder.year(2023);
        builder.brand("Mercedes-Benz");
        builder.price(60000L);
        builder.climateControl(true);
        builder.gps(true);
        builder.print();
        Car car = builder.build();

        assertNotNull(car);
        assertEquals("Blue", car.getColor());
        assertEquals("Comfort", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals("Mercedes-Benz", car.getBrand());
        assertEquals(60000L, car.getPrice());
        assertTrue(car.isGps());
        assertTrue(car.isClimateControl());
    }

    @Test
    void testBuildBasicCar() {
        Builder builder = new CarBuilder();
        builder.color("Gray");
        builder.model("Basic");
        builder.year(2023);
        builder.brand("Toyota");
        builder.price(25000L);
        builder.print();
        Car car = builder.build();

        assertNotNull(car);
        assertEquals("Gray", car.getColor());
        assertEquals("Basic", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals("Toyota", car.getBrand());
        assertEquals(25000L, car.getPrice());
        assertFalse(car.isGps());
        assertFalse(car.isClimateControl());
    }
}
