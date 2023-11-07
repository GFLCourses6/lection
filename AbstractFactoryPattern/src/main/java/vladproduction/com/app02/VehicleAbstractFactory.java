package vladproduction.com.app02;

import vladproduction.com.app02.kia.KiaFactory;
import vladproduction.com.app02.subaru.SubaruFactory;
import vladproduction.com.app02.toyota.ToyotaFactory;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.*;

public class VehicleAbstractFactory {

    public static Vehicle createVehicle(ManufactureType manufactureType, VehicleType vehicleType){
        VehicleFactory vehicleFactory = findVehicleFactory(manufactureType);
        if(MINI.equals(vehicleType)){
             return vehicleFactory.createMini();
        }
        if(JEEP.equals(vehicleType)){
            return vehicleFactory.createJeep();
        }
        if(SUV.equals(vehicleType)){
            return vehicleFactory.createSUV();
        }
        throw new IllegalArgumentException("incorrect Vehicle type");
    }

    private static VehicleFactory findVehicleFactory(ManufactureType mt){
        return switch (mt) {
            case TOYOTA -> new ToyotaFactory();
            case KIA -> new KiaFactory();
            case SUBARU -> new SubaruFactory();
            default -> throw new IllegalArgumentException("incorrect Manufacture type");
        };
    }

    public enum ManufactureType{
        TOYOTA, KIA, SUBARU
    }

    public enum VehicleType{
        MINI, JEEP, SUV
    }
}
