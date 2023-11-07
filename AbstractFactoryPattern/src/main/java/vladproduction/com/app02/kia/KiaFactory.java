package vladproduction.com.app02.kia;

import vladproduction.com.app02.*;

public class KiaFactory implements VehicleFactory {

    @Override
    public Vehicle createMini() { return new MiniKiaVehicle();
    }
    @Override
    public Vehicle createJeep() { return new JeepKiaVehicle();
    }
    @Override
    public Vehicle createSUV() {  return new SUVKiaVehicle();
    }
}
