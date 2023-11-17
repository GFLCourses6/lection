package com.ua.factory.vehicle.climate;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.kia.climate.KiaClimateControl;
import com.ua.factory.vehicle.kia.climate.KiaClimateControlBuilder;
import com.ua.factory.vehicle.kia.creator.Kia;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControlBuilder;
import com.ua.factory.vehicle.toyota.creator.Toyota;

public class ClimateControlFacade {

    private final KiaClimateControlBuilder kiaClimateBuilder;
    private final ToyotaClimateControlBuilder toyotaClimateBuilder;

    public ClimateControlFacade() {
        this.kiaClimateBuilder = new KiaClimateControlBuilder();
        this.toyotaClimateBuilder = new ToyotaClimateControlBuilder();
    }

    public ClimateControlFacade(
            KiaClimateControlBuilder kiaClimateBuilder,
            ToyotaClimateControlBuilder toyotaClimateBuilder) {
        this.kiaClimateBuilder = kiaClimateBuilder;
        this.toyotaClimateBuilder = toyotaClimateBuilder;
    }

    public void upgrade(Vehicle vehicle) {
        if (vehicle instanceof Kia kia) {
            kia.upgradeClimate(getMultiZoneKiaClimate());
        } else if (vehicle instanceof Toyota toyota) {
            toyota.upgradeClimate(getMultiZoneToyotaClimate());
        }
    }

    private static final class ClimateControlFacadeHolder {
        private static final ClimateControlFacade INSTANCE =
                new ClimateControlFacade();
    }

    public static ClimateControlFacade getInstanceClimate() {
        return ClimateControlFacadeHolder.INSTANCE;
    }

    public KiaClimateControl getBasicKiaClimate() {
        return kiaClimateBuilder.createBasic();
    }

    public ToyotaClimateControl getBasicToyotaClimate() {
        return toyotaClimateBuilder.createBasic();
    }

    public KiaClimateControl getMultiZoneKiaClimate() {
        return kiaClimateBuilder.createMultiZone();
    }

    public ToyotaClimateControl getMultiZoneToyotaClimate() {
        return toyotaClimateBuilder.createMultiZone();
    }
}
