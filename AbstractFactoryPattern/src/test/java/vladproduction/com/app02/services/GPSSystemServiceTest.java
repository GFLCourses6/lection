package vladproduction.com.app02.services;

import org.junit.jupiter.api.Test;
import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.GPSSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.SUBARU;
import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.SUV;

public class GPSSystemServiceTest {

    @Test
    public void gpsUpdateBaseOnHashCode(){

        GPSSystemService gpsSystemService = new GPSSystemService();
        Vehicle v = VehicleAbstractFactory.createVehicle(SUBARU, SUV);
        int beforeUpdateHash = v.hashCode();
        gpsSystemService.update(v, new GPSSystem("Test-gps"));
        int afterUpdateHash = v.hashCode();
        assertNotEquals(beforeUpdateHash, afterUpdateHash);
    }

    @Test
    public void gpsUpdateBaseOnGPS(){

        GPSSystemService gpsSystemService = new GPSSystemService();
        Vehicle v = VehicleAbstractFactory.createVehicle(SUBARU, SUV);
        GPSSystem testGPS = new GPSSystem("TestGPS");
        gpsSystemService.update(v, testGPS);
        AbstractVehicle av = (AbstractVehicle) v;
        GPSSystem afterUpdate = av.getGpsSystem();
        assertEquals(testGPS.getModel(), afterUpdate.getModel());

    }

}