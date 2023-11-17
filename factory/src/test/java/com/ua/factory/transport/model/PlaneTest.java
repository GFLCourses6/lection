package com.ua.factory.transport.model;

import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.driver.SmartAutoDriver;
import com.ua.factory.transport.navigator.GpsNavigator;
import com.ua.factory.transport.navigator.IntegratedGpsNavigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlaneTest {

    @Test
    void testCreate() {
        Driver<Bmw> driver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> navigator = new IntegratedGpsNavigator<>();
        Plane<Bmw> plane = new Plane<>(driver, navigator);
        plane.create();
        assertNotNull(plane);
        assertNotNull(plane.driver);
        assertNotNull(plane.navigator);
    }

    @Test
    void testEqualsAndHashCode() {
        Driver<Bmw> autoDriver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> bmwGpsNavigator = new IntegratedGpsNavigator<>();
        Plane<Bmw> plane = new Plane<>(autoDriver, bmwGpsNavigator);
        GpsNavigator<Bmw> gpsNavigator = new IntegratedGpsNavigator<>();
        Plane<Bmw> bmwPlane = new Plane<>(autoDriver, bmwGpsNavigator);

        assertEquals(plane, bmwPlane);
        assertEquals(plane.hashCode(), bmwPlane.hashCode());

        bmwPlane = new Plane<>(autoDriver, gpsNavigator);
        assertNotEquals(plane, bmwPlane);
        assertNotEquals(plane.hashCode(), bmwPlane.hashCode());
    }

}
