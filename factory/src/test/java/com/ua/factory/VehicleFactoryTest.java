package com.ua.factory;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.VehicleBuildFactory;
import com.ua.factory.vehicle.audio.AudioSystemBuildFactory;
import com.ua.factory.vehicle.climate.ClimateControlBuildFactory;
import com.ua.factory.vehicle.kia.creator.Kia;
import com.ua.factory.vehicle.kia.creator.KiaFactory;
import com.ua.factory.vehicle.toyota.creator.Toyota;
import com.ua.factory.vehicle.toyota.creator.ToyotaFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VehicleFactoryTest {


    @Test
    void testKiaFactory() {
        KiaFactory kiaFactory = mock(KiaFactory.class);
        Kia kia = mock(Kia.class);
        when(kiaFactory.createCar()).thenReturn(kia);
        VehicleBuildFactory buildToyotaFactory =
                new VehicleBuildFactory(kiaFactory);
        Vehicle buildTruck = buildToyotaFactory.buildCar();
        assertEquals(kia, buildTruck);
        AudioSystemBuildFactory audioSystemFactory =
                new AudioSystemBuildFactory(kia);
        audioSystemFactory.upgrade();
        verify(kiaFactory).createCar();
    }

    @Test
    void testToyotaFactory() {
        ToyotaFactory toyotaFactory = mock(ToyotaFactory.class);
        Toyota truck = mock(Toyota.class);
        when(toyotaFactory.createTruck()).thenReturn(truck);
        VehicleBuildFactory buildToyotaFactory =
                new VehicleBuildFactory(toyotaFactory);
        Vehicle builtTruck = buildToyotaFactory.buildTruck();
        assertEquals(truck, builtTruck);
        ClimateControlBuildFactory climateControlBuildFactory =
                new ClimateControlBuildFactory(builtTruck);
        climateControlBuildFactory.upgrade();
        verify(toyotaFactory).createTruck();
    }
}
