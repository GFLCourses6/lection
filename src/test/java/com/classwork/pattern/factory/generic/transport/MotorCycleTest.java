package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.driver.ManualAutoDriver;
import com.classwork.pattern.factory.generic.driver.SmartAutoDriver;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;
import com.classwork.pattern.factory.generic.navigator.IntegratedGpsNavigator;
import com.classwork.pattern.factory.generic.navigator.StandAloneGpsNavigator;
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
