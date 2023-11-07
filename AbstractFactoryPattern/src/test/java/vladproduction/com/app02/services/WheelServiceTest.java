package vladproduction.com.app02.services;

import org.junit.jupiter.api.Test;
import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.Wheel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.TOYOTA;
import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.MINI;

public class WheelServiceTest {

    @Test
    public void wheelUpdateTestBasedOnHashCode(){
        WheelService wheelService = new WheelService();
        Vehicle v = VehicleAbstractFactory.createVehicle(TOYOTA, MINI);
        int beforeUpdateHash = v.hashCode();
        wheelService.update(v, new Wheel("Test",20));
        int afterUpdateHash = v.hashCode();
        assertNotEquals(beforeUpdateHash, afterUpdateHash);
    }

    @Test
    public void wheelUpdateTestBasedOnWheel(){
        WheelService wheelService = new WheelService();
        Vehicle v = VehicleAbstractFactory.createVehicle(TOYOTA, MINI);

        Wheel testWheel = new Wheel("Test",20);
        wheelService.update(v, testWheel);

        AbstractVehicle av = (AbstractVehicle) v;
        Wheel afterUpdateWheel = av.getWheel();
        assertEquals(testWheel.getBrand(), afterUpdateWheel.getBrand());
        assertEquals(testWheel.getSize(), afterUpdateWheel.getSize());


    }

}
