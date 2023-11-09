package com.classwork.pattern.factory.toyota.creator;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.VehicleBuildFactory;
import com.classwork.pattern.factory.VehicleFactory;
import com.classwork.pattern.factory.climate.ClimateControlBuildFactory;
import com.classwork.pattern.factory.toyota.climate.BasicToyotaClimateControl;
import com.classwork.pattern.factory.toyota.climate.MultiZoneToyotaClimateControl;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControl;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControlBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ToyotaFactoryTest {

    private VehicleFactory toyotaFactory;
    private ByteArrayOutputStream outContent;
    private ToyotaClimateControlBuilder toyotaClimateControlBuilder;

    @BeforeEach
    void setUp() {
        toyotaFactory = new ToyotaFactory();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        toyotaClimateControlBuilder = new ToyotaClimateControlBuilder();
    }

    @Test
    void testCreateBus() {
        Vehicle bus = toyotaFactory.createBus();
        assertTrue(bus instanceof ToyotaBus);
        assertNotNull(bus);
    }

    @Test
    void testCreateTruck() {
        Vehicle truck = toyotaFactory.createTruck();
        assertTrue(truck instanceof ToyotaTruck);
        assertNotNull(truck);
    }

    @Test
    void testCreateCar() {
        Vehicle car = toyotaFactory.createCar();
        assertTrue(car instanceof ToyotaCar);
        assertNotNull(car);
    }

    @Test
    void testCreateVehicleCar() {
        Vehicle car = toyotaFactory.createCar();
        car.create();
        String expected = "Creating a Toyota Car with Basic Toyota AudioSystem, Basic Toyota ClimateControl";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testCreateVehicleTruck() {
        Vehicle car = toyotaFactory.createTruck();
        car.create();
        String expected = "Creating a Toyota Truck with Basic Toyota AudioSystem, Basic Toyota ClimateControl";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testCreateVehicleBus() {
        Vehicle car = toyotaFactory.createBus();
        car.create();
        String expected = "Creating a Toyota Bus with Basic Toyota AudioSystem, Basic Toyota ClimateControl";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testCreateBasic() {
        ToyotaClimateControl basicClimateControl = toyotaClimateControlBuilder.createBasic();
        assertTrue(basicClimateControl instanceof BasicToyotaClimateControl);
        assertEquals("Basic Toyota ClimateControl", outContent.toString().trim());
        assertNotNull(basicClimateControl);
    }

    @Test
    void testCreateMultiZone() {
        ToyotaClimateControl multiZoneClimateControl = toyotaClimateControlBuilder.createMultiZone();
        assertTrue(multiZoneClimateControl instanceof MultiZoneToyotaClimateControl);
        assertEquals("Multi-Zone Toyota Climate Control", outContent.toString().trim());
        assertNotNull(multiZoneClimateControl);
    }

    @Test
    void testToyotaFactory() {
        VehicleBuildFactory buildToyotaFactory = new VehicleBuildFactory(toyotaFactory);

        Vehicle truck = buildToyotaFactory.buildTruck();
        ClimateControlBuildFactory climateControlBuildFactory = new ClimateControlBuildFactory(truck);
        climateControlBuildFactory.upgrade();
        assertNotNull(truck);

        Vehicle bus = buildToyotaFactory.buildBus();
        assertNotNull(bus);
        Vehicle car = buildToyotaFactory.buildCar();
        assertNotNull(car);
    }
}
