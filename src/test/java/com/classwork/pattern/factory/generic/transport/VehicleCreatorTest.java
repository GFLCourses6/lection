package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.navigator.GpsNavigatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleCreatorTest {

    @Test
    void testName() {
        VehicleCreator<Bmw> factory = new VehicleCreator<>();
        Transport<Bmw> bmw = factory.create("Plane");
        GpsNavigatorFactory<Bmw> navigatorFactory = new GpsNavigatorFactory<>();
        bmw.updateNavigator(navigatorFactory.create("Integrate"));
        System.out.println(bmw);
    }

    @Test
    void testGeneric() {
        VehicleCreator<Bmw> creator = new VehicleCreator<>();
        Transport<Bmw> bmw = creator.create("Plane");
        assertTrue(bmw instanceof Plane);
        System.out.println(bmw.getClass());
    }

}