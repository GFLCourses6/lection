package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.driver.SmartAutoDriver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;
import com.classwork.pattern.factory.generic.navigator.IntegratedGpsNavigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ShipTest {

    @Test
    void testCreate() {
        Driver<Bmw> driver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> navigator = new IntegratedGpsNavigator<>();
        Ship<Bmw> ship = new Ship<>(driver, navigator);
        ship.create();
        assertEquals("Ship{driver=SmartAutoDriver, navigator=IntegratedGpsNavigator}",
                ship.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Driver<Bmw> autoDriver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> navigator = new IntegratedGpsNavigator<>();
        Ship<Bmw> ship = new Ship<>(autoDriver, navigator);
        Ship<Bmw> bmwShip = new Ship<>(autoDriver, navigator);
        assertEquals(ship, bmwShip);
        assertEquals(ship.hashCode(), bmwShip.hashCode());
        Driver<Bmw> bmwDriver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> gpsNavigator = new IntegratedGpsNavigator<>();
        bmwShip = new Ship<>(bmwDriver, gpsNavigator);
        assertNotEquals(ship, bmwShip);
        assertNotEquals(ship.hashCode(), bmwShip.hashCode());
    }
}
