package com.ua.factory.vehicle.toyota.creator;

import com.ua.factory.vehicle.toyota.audio.ToyotaAudioSystem;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ToyotaCarTest {
    private ToyotaCar toyotaCar;
    private ToyotaAudioSystem toyotaAudioSystem;
    private ToyotaClimateControl toyotaClimateControl;

    @BeforeEach
    public void setUp() {
        toyotaAudioSystem = mock(ToyotaAudioSystem.class);
        toyotaClimateControl = mock(ToyotaClimateControl.class);
        toyotaCar = new ToyotaCar(toyotaAudioSystem, toyotaClimateControl);
    }

    @Test
    void testCreateNewToyotaCar() {
        ToyotaCar toyotaCarSpy = spy(new ToyotaCar(toyotaAudioSystem, toyotaClimateControl));
        doNothing().when(toyotaCarSpy).create();
        toyotaCarSpy.create();
        assertNotNull(toyotaCarSpy);
        verify(toyotaCarSpy, times(1)).create();
    }

    @Test
    void testUpgradeAudio() {
        ToyotaAudioSystem newAudioSystem = mock(ToyotaAudioSystem.class);
        toyotaCar.upgradeAudio(newAudioSystem);
        assertEquals(newAudioSystem, toyotaCar.toyotaAudioSystem);
    }

    @Test
    void testUpgradeClimate() {
        ToyotaClimateControl newClimateControl = mock(ToyotaClimateControl.class);
        toyotaCar.upgradeClimate(newClimateControl);
        assertEquals(newClimateControl, toyotaCar.toyotaClimateControl);
    }

    @Test
    void testUpgradeClimateControl() {
        ToyotaClimateControl newClimateControl = mock(ToyotaClimateControl.class);
        ToyotaCar toyotaCarSpy = spy(toyotaCar);
        doAnswer(invocation -> {
            toyotaCarSpy.toyotaClimateControl = newClimateControl;
            return null;
        }).when(toyotaCarSpy).upgradeClimate(newClimateControl);

        toyotaCarSpy.upgradeClimate(newClimateControl);
        verify(toyotaCarSpy, times(1)).upgradeClimate(newClimateControl);
        assertNotNull(toyotaCarSpy.toyotaClimateControl);
        assertEquals(newClimateControl, toyotaCarSpy.toyotaClimateControl);
    }
}
