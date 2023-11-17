package com.ua.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    void testEquals() {
        Car car1 = new Car("Ferrari",
                           "Enzo",
                           2023,
                           "Red",
                           200000L,
                           true,
                           false);
        Car car2 = new Car("Ferrari",
                           "Enzo",
                           2023,
                           "Red",
                           200000L,
                           true,
                           false);
        Car car3 = new Car("Mercedes-Benz",
                           "E-Class",
                           2023,
                           "Blue",
                           60000L,
                           true,
                           true);

        assertTrue(car1.equals(car2));
        assertFalse(car1.equals(car3));
    }

    @Test
    void testHashCode() {
        Car car1 = new Car("Ferrari",
                           "Enzo",
                           2023,
                           "Red",
                           200000L,
                           true,
                           false);
        Car car2 = new Car("Ferrari",
                           "Enzo",
                           2023,
                           "Red",
                           200000L,
                           true,
                           false);

        assertEquals(car1.hashCode(),
                     car2.hashCode());
    }

    @Test
    void testToString() {
        Car car = new Car("Ferrari",
                          "Enzo",
                          2023,
                          "Red",
                          200000L,
                          true,
                          false);
        String expectedString = "Car{brand='Ferrari', model='Enzo', year=2023, color='Red', price=200000, gps=true, climateControl=false}\n";
        assertEquals(expectedString.trim(),
                     car.toString().trim());
    }

    @Test
    void testConstructor() {
        Car car = new Car();
        assertNull(car.getBrand());
        assertNull(car.getModel());
        assertNull(car.getColor());
        assertNull(car.getPrice());
        assertFalse(car.isGps());
        assertFalse(car.isClimateControl());
    }
}