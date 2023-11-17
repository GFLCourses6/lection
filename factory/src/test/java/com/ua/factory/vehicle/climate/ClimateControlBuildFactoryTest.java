package com.ua.factory.vehicle.climate;

import com.ua.factory.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ClimateControlBuildFactoryTest {
    private Vehicle vehicle;
    private ClimateControlFacade facade;
    private ClimateControlBuildFactory climateControlBuildFactory;

    @BeforeEach
    public void setUp() {
        vehicle = mock(Vehicle.class);
        facade = Mockito.mock(ClimateControlFacade.class);
        climateControlBuildFactory = new ClimateControlBuildFactory(vehicle);
        climateControlBuildFactory.facade = facade;
    }

    @Test
    void testUpgrade() {
        doNothing().when(facade).upgrade(vehicle);
        climateControlBuildFactory.upgrade();
        verify(facade, times(1)).upgrade(vehicle);
    }
}
