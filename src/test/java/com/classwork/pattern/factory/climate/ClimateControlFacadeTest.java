package com.classwork.pattern.factory.climate;

import com.classwork.pattern.factory.kia.climate.KiaClimateControl;
import com.classwork.pattern.factory.kia.climate.KiaClimateControlBuilder;
import com.classwork.pattern.factory.kia.creator.Kia;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControl;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControlBuilder;
import com.classwork.pattern.factory.toyota.creator.Toyota;
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
        ClimateControlFacade facade = new ClimateControlFacade(kiaClimateBuilder, new ToyotaClimateControlBuilder());
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
