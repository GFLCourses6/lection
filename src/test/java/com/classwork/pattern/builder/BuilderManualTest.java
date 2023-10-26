package com.classwork.pattern.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderManualTest {

    @Test
    void testBuildSportsCar() {
        BuilderManual builder = new CarBuilderManual();
        Car car = builder
                .color("Red")
                .model("Sports")
                .year(2023)
                .brand("Ferrari")
                .price(200000L)
                .gps(true)
                .build();

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
        BuilderManual builder = new CarBuilderManual();
        Car car = builder
                .color("Blue")
                .model("Comfort")
                .year(2023)
                .brand("Mercedes-Benz")
                .price(60000L)
                .climateControl(true)
                .gps(true)
                .build();

        assertNotNull(car);
        assertEquals("Blue", car.getColor());
        assertEquals("Comfort", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals("Mercedes-Benz", car.getBrand());
        assertEquals(60000L, car.getPrice());
        assertTrue(car.isClimateControl());
        assertTrue(car.isGps());
    }

    @Test
    void testBuildBasicCar() {
        BuilderManual builder = new CarBuilderManual();
        Car car = builder
                .color("Gray")
                .model("Basic")
                .year(2023)
                .brand("Toyota")
                .price(25000L)
                .build();

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
