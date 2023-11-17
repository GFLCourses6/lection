package com.ua.factory.vehicle.kia.climate;

import com.ua.factory.vehicle.climate.ClimateControlFactory;

public class KiaClimateControlBuilder
        implements ClimateControlFactory {
    @Override
    public KiaClimateControl createBasic() {
        KiaClimateControl basicClimateControl =
                new BasicKiaClimateControl();
        System.out.println(basicClimateControl);
        return basicClimateControl;
    }

    @Override
    public KiaClimateControl createMultiZone() {
        KiaClimateControl multiZoneClimateControl =
                new MultiZoneKiaClimateControl();
        System.out.println(multiZoneClimateControl);
        return multiZoneClimateControl;
    }
}
