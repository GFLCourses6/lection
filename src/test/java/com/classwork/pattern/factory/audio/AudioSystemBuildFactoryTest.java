package com.classwork.pattern.factory.audio;

import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.kia.audio.KiaAudioSystemBuilder;
import com.classwork.pattern.factory.kia.creator.Kia;
import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystem;
import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystemBuilder;
import com.classwork.pattern.factory.toyota.creator.Toyota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AudioSystemBuildFactoryTest {

    private Vehicle vehicle;
    private AudioSystemFacade facade;
    private AudioSystemBuildFactory audioSystemBuildFactory;

    @BeforeEach
    public void setUp() {
        vehicle = mock(Vehicle.class);
        facade = Mockito.mock(AudioSystemFacade.class);
        audioSystemBuildFactory = new AudioSystemBuildFactory(vehicle);
        audioSystemBuildFactory.facade = facade;
    }

    @Test
    void testUpgradeKia() {
        Kia kia = mock(Kia.class);
        KiaAudioSystem highEndKiaAudio = mock(KiaAudioSystem.class);
        KiaAudioSystemBuilder kiaAudioBuilder = mock(KiaAudioSystemBuilder.class);
        when(kiaAudioBuilder.createHighEnd()).thenReturn(highEndKiaAudio);
        AudioSystemFacade facade = new AudioSystemFacade(kiaAudioBuilder, new ToyotaAudioSystemBuilder());
        facade.upgrade(kia);
        verify(kia).upgradeAudio(highEndKiaAudio);
    }

    @Test
    void testUpgradeToyota() {
        Toyota toyota = mock(Toyota.class);
        ToyotaAudioSystem highEndToyotaAudio = mock(ToyotaAudioSystem.class);
        ToyotaAudioSystemBuilder toyotaAudioBuilder = mock(ToyotaAudioSystemBuilder.class);
        when(toyotaAudioBuilder.createHighEnd()).thenReturn(highEndToyotaAudio);
        AudioSystemFacade facade = new AudioSystemFacade(new KiaAudioSystemBuilder(), toyotaAudioBuilder);
        facade.upgrade(toyota);
        verify(toyota).upgradeAudio(highEndToyotaAudio);
    }

    @Test
    void testUpgrade() {
        doNothing().when(facade).upgrade(vehicle);
        audioSystemBuildFactory.upgrade();
        verify(facade, times(1)).upgrade(vehicle);
    }
}
