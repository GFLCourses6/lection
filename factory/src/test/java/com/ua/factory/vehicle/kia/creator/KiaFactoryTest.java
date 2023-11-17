package com.ua.factory.vehicle.kia.creator;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.VehicleBuildFactory;
import com.ua.factory.vehicle.VehicleFactory;
import com.ua.factory.vehicle.audio.AudioSystemBuildFactory;
import com.ua.factory.vehicle.kia.climate.BasicKiaClimateControl;
import com.ua.factory.vehicle.kia.climate.KiaClimateControl;
import com.ua.factory.vehicle.kia.climate.KiaClimateControlBuilder;
import com.ua.factory.vehicle.kia.climate.MultiZoneKiaClimateControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KiaFactoryTest {
    private VehicleFactory kiaFactory;
    private ByteArrayOutputStream outContent;
    private KiaClimateControlBuilder kiaClimateControlBuilder;

    @BeforeEach
    void setUp() {
        kiaFactory = new KiaFactory();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        kiaClimateControlBuilder = new KiaClimateControlBuilder();
    }

    @Test
    void testCreateBus() {
        Vehicle bus = kiaFactory.createBus();
        assertTrue(bus instanceof KiaBus);
        assertNotNull(bus);
    }

    @Test
    void testCreateTruck() {
        Vehicle truck = kiaFactory.createTruck();
        assertTrue(truck instanceof KiaTruck);
        assertNotNull(truck);
    }

    @Test
    void testCreateCar() {
        Vehicle car = kiaFactory.createCar();
        assertTrue(car instanceof KiaCar);
        assertNotNull(car);
    }

    @Test
    void testCreateVehicleCar() {
        Vehicle car = kiaFactory.createCar();
        car.create();
        String expected = "Creating a Kia Car with Basic Kia AudioSystem, Basic Kia ClimateControl";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testCreateVehicleTruck() {
        Vehicle car = kiaFactory.createTruck();
        car.create();
        String expected = "Creating a Kia Truck with Basic Kia AudioSystem, Basic Kia ClimateControl";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testCreateVehicleBus() {
        Vehicle car = kiaFactory.createBus();
        car.create();
        String expected = "Creating a Kia Bus with Basic Kia AudioSystem, Basic Kia ClimateControl";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testCreateBasic() {
        KiaClimateControl basicClimateControl = kiaClimateControlBuilder.createBasic();
        assertTrue(basicClimateControl instanceof BasicKiaClimateControl);
        assertEquals("Basic Kia ClimateControl", outContent.toString().trim());
        assertNotNull(basicClimateControl);
    }

    @Test
    void testCreateMultiZone() {
        KiaClimateControl multiZoneClimateControl = kiaClimateControlBuilder.createMultiZone();
        assertTrue(multiZoneClimateControl instanceof MultiZoneKiaClimateControl);
        assertEquals("Multi-Zone Kia Climate Control", outContent.toString().trim());
        assertNotNull(multiZoneClimateControl);
    }

    @Test
    void testKiaFactory() {
        VehicleBuildFactory buildKiaFactory = new VehicleBuildFactory(kiaFactory);
        Vehicle car = buildKiaFactory.buildCar();
        assertNotNull(car);
        AudioSystemBuildFactory audioSystemFactory = new AudioSystemBuildFactory(car);
        audioSystemFactory.upgrade();
        Vehicle truck = buildKiaFactory.buildTruck();
        assertNotNull(truck);
        Vehicle bus = buildKiaFactory.buildBus();
        assertNotNull(bus);
    }
}
