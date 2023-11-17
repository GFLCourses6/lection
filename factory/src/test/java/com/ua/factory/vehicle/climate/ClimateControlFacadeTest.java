package com.ua.factory.vehicle.climate;

import com.ua.factory.vehicle.kia.climate.KiaClimateControl;
import com.ua.factory.vehicle.kia.climate.KiaClimateControlBuilder;
import com.ua.factory.vehicle.kia.creator.Kia;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControlBuilder;
import com.ua.factory.vehicle.toyota.creator.Toyota;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClimateControlFacadeTest {

    @Test
    void testUpgradeKia() {
        Kia kia = mock(Kia.class);
        KiaClimateControl multiZoneKiaClimate = mock(KiaClimateControl.class);
        KiaClimateControlBuilder kiaClimateBuilder = mock(KiaClimateControlBuilder.class);
        when(kiaClimateBuilder.createMultiZone()).thenReturn(multiZoneKiaClimate);
        ClimateControlFacade
                facade = new ClimateControlFacade(kiaClimateBuilder, new ToyotaClimateControlBuilder());
        facade.upgrade(kia);
        verify(kia).upgradeClimate(multiZoneKiaClimate);
    }

    @Test
    void testUpgradeToyota() {
        Toyota toyota = mock(Toyota.class);
        ToyotaClimateControl multiZoneToyotaClimate = mock(ToyotaClimateControl.class);
        ToyotaClimateControlBuilder toyotaClimateBuilder = mock(ToyotaClimateControlBuilder.class);
        when(toyotaClimateBuilder.createMultiZone()).thenReturn(multiZoneToyotaClimate);
        ClimateControlFacade facade = new ClimateControlFacade(new KiaClimateControlBuilder(), toyotaClimateBuilder);
        facade.upgrade(toyota);
        verify(toyota).upgradeClimate(multiZoneToyotaClimate);
    }
}
