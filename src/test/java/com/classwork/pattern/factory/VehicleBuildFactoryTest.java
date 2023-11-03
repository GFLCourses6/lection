package com.classwork.pattern.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VehicleBuildFactoryTest {
    VehicleFactory vehicleFactory;
    @BeforeEach
    public void setUp() {
        vehicleFactory = mock(VehicleFactory.class);
    }

    @Test
    void testBuildCar() {
        Vehicle car = mock(Vehicle.class);
        when(vehicleFactory.createCar()).thenReturn(car);
        VehicleBuildFactory buildFactory = new VehicleBuildFactory(vehicleFactory);
        Vehicle result = buildFactory.buildCar();
        verify(car).create();
        assertEquals(car, result);
    }

    @Test
    void testBuildBus() {
        Vehicle bus = mock(Vehicle.class);
        when(vehicleFactory.createBus()).thenReturn(bus);
        VehicleBuildFactory buildFactory = new VehicleBuildFactory(vehicleFactory);
        Vehicle result = buildFactory.buildBus();
        verify(bus).create();
        assertEquals(bus, result);
    }

    @Test
    void testBuildTruck() {
        Vehicle truck = mock(Vehicle.class);
        when(vehicleFactory.createTruck()).thenReturn(truck);
        VehicleBuildFactory buildFactory = new VehicleBuildFactory(vehicleFactory);
        Vehicle result = buildFactory.buildTruck();
        verify(truck).create();
        assertEquals(truck, result);
    }
}