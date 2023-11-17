package com.ua.factory.transport.model;

import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.driver.ManualAutoDriver;
import com.ua.factory.transport.driver.SmartAutoDriver;
import com.ua.factory.transport.navigator.GpsNavigator;
import com.ua.factory.transport.navigator.IntegratedGpsNavigator;
import com.ua.factory.transport.navigator.StandAloneGpsNavigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MotorCycleTest {

    @Test
    void testCreate() {
        Driver<Bmw> autoDriver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> navigator = new IntegratedGpsNavigator<>();
        MotorCycle<Bmw> motorCycle = new MotorCycle<>(autoDriver, navigator);
        motorCycle.create();
        assertNotNull(motorCycle);
        assertEquals("MotorCycle{driver=SmartAutoDriver, navigator=IntegratedGpsNavigator}",
                motorCycle.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Driver<Bmw> autoDriver = new SmartAutoDriver<>();
        GpsNavigator<Bmw> navigator = new IntegratedGpsNavigator<>();
        MotorCycle<Bmw> motorCycle = new MotorCycle<>(autoDriver, navigator);
        MotorCycle<Bmw> bmwMotorCycle = new MotorCycle<>(autoDriver, navigator);
        assertEquals(motorCycle, bmwMotorCycle);
        assertEquals(motorCycle.hashCode(), bmwMotorCycle.hashCode());
        Driver<Bmw> bmwDriver = new ManualAutoDriver<>();
        GpsNavigator<Bmw> bmwGpsNavigator = new StandAloneGpsNavigator<>();
        bmwMotorCycle = new MotorCycle<>(bmwDriver, bmwGpsNavigator);
        assertNotEquals(motorCycle, bmwMotorCycle);
        assertNotEquals(motorCycle.hashCode(), bmwMotorCycle.hashCode());
    }
}
