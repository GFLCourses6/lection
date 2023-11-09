package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.driver.ManualDrive;
import com.classwork.pattern.factory.generic.driver.SmartAutoDriver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;
import com.classwork.pattern.factory.generic.navigator.StandAloneGpsNavigator;
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
