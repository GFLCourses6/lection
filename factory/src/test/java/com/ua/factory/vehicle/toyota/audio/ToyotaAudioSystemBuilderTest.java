package com.ua.factory.vehicle.toyota.audio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ToyotaAudioSystemBuilderTest {
    @Test
    void testCreateBasic() {
        ToyotaAudioSystemBuilder builder = new ToyotaAudioSystemBuilder();
        String expected = "Basic Toyota AudioSystem";
        ToyotaAudioSystem actual = builder.createBasic();
        assertEquals(expected, actual.toString());
    }

    @Test
    void testCreateHighEnd() {
        ToyotaAudioSystemBuilder builder = new ToyotaAudioSystemBuilder();
        String expected = "High-End Toyota AudioSystem";
        ToyotaAudioSystem actual = builder.createHighEnd();
        assertEquals(expected, actual.toString());
    }

    @Test
    void testCreateBasicToyotaAudioSystemBuilder() {
        ToyotaAudioSystemBuilder builder = Mockito.mock(ToyotaAudioSystemBuilder.class);
        ToyotaAudioSystem basicAudioSystem = Mockito.mock(
                BasicToyotaAudioSystem.class);
        when(builder.createBasic()).thenReturn(basicAudioSystem);
        ToyotaAudioSystem result = builder.createBasic();
        verify(builder).createBasic();
        assertEquals(basicAudioSystem, result);
    }

    @Test
    void testCreateHighEndToyotaAudioSystemBuilder() {
        ToyotaAudioSystemBuilder builder = Mockito.mock(ToyotaAudioSystemBuilder.class);
        ToyotaAudioSystem highEndAudioSystem = Mockito.mock(ToyotaAudioSystem.class);
        when(builder.createHighEnd()).thenReturn(highEndAudioSystem);
        ToyotaAudioSystem result = builder.createHighEnd();
        verify(builder).createHighEnd();
        assertEquals(highEndAudioSystem, result);
    }
}
