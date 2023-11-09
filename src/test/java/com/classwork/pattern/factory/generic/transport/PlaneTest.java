package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.driver.SmartAutoDriver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;
import com.classwork.pattern.factory.generic.navigator.IntegratedGpsNavigator;
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
