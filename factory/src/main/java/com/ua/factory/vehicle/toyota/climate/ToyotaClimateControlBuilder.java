package com.ua.factory.vehicle.toyota.climate;

import com.ua.factory.vehicle.climate.ClimateControlFactory;

public class ToyotaClimateControlBuilder
        implements ClimateControlFactory {


    @Override
    public ToyotaClimateControl createBasic() {
        ToyotaClimateControl basicClimateControl
                = new BasicToyotaClimateControl();
        System.out.println(basicClimateControl);
        return basicClimateControl;
    }

    @Override
    public ToyotaClimateControl createMultiZone() {
        ToyotaClimateControl multiZoneClimateControl =
                new MultiZoneToyotaClimateControl();
        System.out.println(multiZoneClimateControl);
        return multiZoneClimateControl;
    }
}
