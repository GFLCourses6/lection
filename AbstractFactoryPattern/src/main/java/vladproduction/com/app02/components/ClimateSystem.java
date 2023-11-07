package vladproduction.com.app02.components;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.VehicleAbstractFactory;

import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.*;
import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.*;

public enum ClimateSystem {
        CONDITIONER(null, MINI), CLIMATE_SYSTEM(null, JEEP), NEW_GENERATION(null, SUV),
        CONDITIONER_TOYOTA(TOYOTA, MINI), CONDITIONER_KIA(KIA, MINI), CONDITIONER_SUBARU(SUBARU, MINI),
        CLIMATE_SYSTEM_TOYOTA_JEEP(TOYOTA, JEEP), CLIMATE_SYSTEM_KIA_JEEP(KIA, JEEP), CLIMATE_SYSTEM_SUBARU_JEEP(SUBARU, JEEP),
        NEW_GENERATION_TOYOTA(TOYOTA, SUV), NEW_GENERATION_KIA(KIA, SUV), NEW_GENERATION_SUBARU(SUBARU, SUV);

        private VehicleAbstractFactory.ManufactureType manufactureType;
        private VehicleAbstractFactory.VehicleType vehicleType;

        ClimateSystem(VehicleAbstractFactory.ManufactureType manufactureType,
                      VehicleAbstractFactory.VehicleType vehicleType) {
                this.manufactureType = manufactureType;
                this.vehicleType = vehicleType;
        }

        public VehicleAbstractFactory.ManufactureType getManufactureType() {
                return manufactureType;
        }

        public VehicleAbstractFactory.VehicleType getVehicleType() {
                return vehicleType;
        }
}
