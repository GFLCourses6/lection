package com.ua.factory.transport.model;

import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.driver.ManualDrive;
import com.ua.factory.transport.driver.SmartAutoDriver;
import com.ua.factory.transport.navigator.GpsNavigator;
import com.ua.factory.transport.navigator.StandAloneGpsNavigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransportTest {

    @Test
    void testEqualsAndHashCode() {
        Driver<Bmw> driver = new ManualDrive<>();
        GpsNavigator<Bmw> navigator = new StandAloneGpsNavigator<>();

        Transport<Bmw> bmwPlane = new Plane<>(driver, navigator);
        Transport<Bmw> plane = new Plane<>(driver, navigator);
        assertTrue(bmwPlane.equals(plane) && plane.equals(bmwPlane));
        assertEquals(bmwPlane.hashCode(), plane.hashCode());
        plane.updateDriver(new SmartAutoDriver<>());
        assertFalse(bmwPlane.equals(plane) || plane.equals(bmwPlane));
        assertNotEquals(bmwPlane.hashCode(), plane.hashCode());
    }
}
