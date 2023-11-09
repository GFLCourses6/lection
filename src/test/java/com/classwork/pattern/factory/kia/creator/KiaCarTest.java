package com.classwork.pattern.factory.kia.creator;

import com.classwork.pattern.factory.audio.AudioSystem;
import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.kia.climate.KiaClimateControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class KiaCarTest {
    private KiaCar kiaCar;
    private KiaAudioSystem kiaAudioSystem;
    private KiaClimateControl kiaClimateControl;

    @BeforeEach
    public void setUp() {
        kiaAudioSystem = mock(KiaAudioSystem.class);
        kiaClimateControl = mock(KiaClimateControl.class);
        kiaCar = new KiaCar(kiaAudioSystem, kiaClimateControl);
    }

    @Test
    void testCreateNewKiaCar() {
        assertNotNull(kiaCar);
        assertNotNull(kiaCar.kiaAudioSystem);
        assertNotNull(kiaCar.kiaClimateControl);
    }

    @Test
    void testCreateMockNewKiaCar() {
        KiaCar kiaCarSpy = spy(new KiaCar(kiaAudioSystem, kiaClimateControl));
        doNothing().when(kiaCarSpy).create();
        kiaCarSpy.create();
        assertNotNull(kiaCarSpy);
        verify(kiaCarSpy, times(1)).create();
    }

    @Test
    void testUpgradeAudio() {
        KiaAudioSystem newAudioSystem = mock(KiaAudioSystem.class);
        kiaCar.upgradeAudio(newAudioSystem);
        assertEquals(newAudioSystem, kiaCar.kiaAudioSystem);
    }

    @Test
    void testUpgradeClimate() {
        KiaClimateControl newClimateControl = mock(KiaClimateControl.class);
        kiaCar.upgradeClimate(newClimateControl);
        assertEquals(newClimateControl, kiaCar.kiaClimateControl);
    }

    @Test
    void testUpgradeClimateControl() {
        KiaClimateControl newClimateControl = mock(KiaClimateControl.class);
        KiaCar kiaCarSpy = spy(kiaCar);
        doAnswer(invocation -> {
            kiaCarSpy.kiaClimateControl = newClimateControl;
            return null;
        }).when(kiaCarSpy).upgradeClimate(newClimateControl);

        kiaCarSpy.upgradeClimate(newClimateControl);
        verify(kiaCarSpy, times(1)).upgradeClimate(newClimateControl);
        assertNotNull(kiaCarSpy.kiaClimateControl);
        assertEquals(newClimateControl, kiaCarSpy.kiaClimateControl);
    }

    @Test
    void testEqualsAndHashCode() {
        KiaAudioSystem audioSystem = mock(KiaAudioSystem.class);
        Kia kiaCar = new KiaCar(kiaAudioSystem, kiaClimateControl);
        Kia car = new KiaCar(kiaAudioSystem, kiaClimateControl);
        assertTrue(kiaCar.equals(car) && car.equals(kiaCar));
        assertEquals(kiaCar.hashCode(), car.hashCode());
        car.upgradeAudio(audioSystem);
        assertFalse(kiaCar.equals(car) || car.equals(kiaCar));
        assertNotEquals(kiaCar.hashCode(), car.hashCode());
    }
}
