package com.ua.factory.transport.model;

import com.ua.factory.transport.VehicleCreator;
import com.ua.factory.transport.navigator.GpsNavigatorFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleCreatorTest {

    @Test
    void testName() {
        VehicleCreator<Bmw> factory = new VehicleCreator<>();
        Transport<Bmw> bmw = factory.create("Plane");
        GpsNavigatorFactory<Bmw> navigatorFactory = new GpsNavigatorFactory<>();
        bmw.updateNavigator(navigatorFactory.create("Integrate"));
        String expect = "Plane{driver=ManualDrive, "
                + "navigator=StandAloneGpsNavigator}";
        assertEquals(expect, bmw.toString());
    }

    @Test
    void testGeneric() {
        VehicleCreator<Bmw> creator = new VehicleCreator<>();
        Transport<Bmw> bmw = creator.create("Plane");
        assertTrue(bmw instanceof Plane);
        System.out.println(bmw.getClass());
    }

    @ParameterizedTest
    @ArgumentsSource(VehicleArgumentsProvider.class)
    void testCreateVehicle(String type, Class<?> expectedClass) {
        VehicleCreator<Bmw> vehicleCreator = new VehicleCreator<>();
        Transport<Bmw> vehicle = vehicleCreator.create(type);
        assertTrue(expectedClass.isInstance(vehicle));
    }
}
