package com.classwork.pattern.factory.toyota.climate;

import com.classwork.pattern.factory.climate.ClimateControlFactory;

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
