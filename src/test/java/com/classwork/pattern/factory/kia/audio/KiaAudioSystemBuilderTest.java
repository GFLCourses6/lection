package com.classwork.pattern.factory.kia.audio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class KiaAudioSystemBuilderTest {

    @Test
    void testCreateBasic() {
        KiaAudioSystemBuilder builder = new KiaAudioSystemBuilder();
        String expected = "Basic Kia AudioSystem";
        KiaAudioSystem actual = builder.createBasic();
        assertEquals(expected, actual.toString());
    }

    @Test
    void testCreateHighEnd() {
        KiaAudioSystemBuilder builder = new KiaAudioSystemBuilder();
        String expected = "High-End Kia AudioSystem";
        KiaAudioSystem actual = builder.createHighEnd();
        assertEquals(expected, actual.toString());
    }

    @Test
    void testCreateBasicKiaAudioSystemBuilder() {
        KiaAudioSystemBuilder builder = Mockito.mock(KiaAudioSystemBuilder.class);
        KiaAudioSystem basicAudioSystem = Mockito.mock(BasicKiaAudioSystem.class);
        when(builder.createBasic()).thenReturn(basicAudioSystem);
        KiaAudioSystem result = builder.createBasic();
        verify(builder).createBasic();
        assertEquals(basicAudioSystem, result);
    }

    @Test
    void testCreateHighEndKiaAudioSystemBuilder() {
        KiaAudioSystemBuilder builder = Mockito.mock(KiaAudioSystemBuilder.class);
        KiaAudioSystem highEndAudioSystem = mock(KiaAudioSystem.class);
        when(builder.createHighEnd()).thenReturn(highEndAudioSystem);
        KiaAudioSystem result = builder.createHighEnd();
        verify(builder).createHighEnd();
        assertEquals(highEndAudioSystem, result);
    }
}
