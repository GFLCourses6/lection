package vladproduction.com.app02.services;

import org.junit.jupiter.api.Test;
import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.subaru.SUVSubaruVehicle;

import static org.junit.jupiter.api.Assertions.*;
import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.KIA;
import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.SUBARU;

class ClimateSystemServiceTest {

    @Test
    public void climateSystemUpdate(){

        AbstractVehicle subaruJeep = (AbstractVehicle) VehicleAbstractFactory.createVehicle(SUBARU, VehicleAbstractFactory.VehicleType.JEEP);
        ClimateSystemService climateSystemService = new ClimateSystemService();
        ClimateSystem climateSystemDefault = subaruJeep.getClimateSystem();
        climateSystemService.update(subaruJeep, ClimateSystem.CLIMATE_SYSTEM_SUBARU_JEEP);
        ClimateSystem climateSystemUpdated = subaruJeep.getClimateSystem();

        assertNotEquals(climateSystemDefault, climateSystemUpdated);

        assertEquals(climateSystemUpdated, ClimateSystem.CLIMATE_SYSTEM_SUBARU_JEEP);

    }

    @Test
    public void climateSystemUpdateByVehicleType(){

        AbstractVehicle subaruJeep = (AbstractVehicle) VehicleAbstractFactory.createVehicle(SUBARU, VehicleAbstractFactory.VehicleType.JEEP);
        ClimateSystemService climateSystemService = new ClimateSystemService();
        ClimateSystem climateSystemDefault = subaruJeep.getClimateSystem();
        climateSystemService.update(subaruJeep, ClimateSystem.CLIMATE_SYSTEM_TOYOTA_JEEP);
        ClimateSystem climateSystemUpdated = subaruJeep.getClimateSystem();

        assertEquals(climateSystemDefault, climateSystemUpdated);

    }

    @Test
    public void climateSystemUpdateByManufactureType(){

        AbstractVehicle subaruJeep = (AbstractVehicle) VehicleAbstractFactory.createVehicle(SUBARU, VehicleAbstractFactory.VehicleType.JEEP);
        ClimateSystemService climateSystemService = new ClimateSystemService();
        ClimateSystem climateSystemDefault = subaruJeep.getClimateSystem();
        climateSystemService.update(subaruJeep, ClimateSystem.CONDITIONER_SUBARU);
        ClimateSystem climateSystemUpdated = subaruJeep.getClimateSystem();

        assertEquals(climateSystemDefault, climateSystemUpdated);

    }

    @Test
    public void climateSystemUpdateByManufactureTypeAndVehicleType(){

        AbstractVehicle kiaMini = (AbstractVehicle) VehicleAbstractFactory.createVehicle(KIA, VehicleAbstractFactory.VehicleType.MINI);
        ClimateSystemService climateSystemService = new ClimateSystemService();
        ClimateSystem climateSystemDefault = kiaMini.getClimateSystem();
        climateSystemService.update(kiaMini, ClimateSystem.NEW_GENERATION_TOYOTA);
        ClimateSystem climateSystemUpdated = kiaMini.getClimateSystem();

        assertEquals(climateSystemDefault, climateSystemUpdated);

    }

}