package com.ua.factory.vehicle.toyota.climate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ToyotaClimateControlBuilderTest {

    private ToyotaClimateControlBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ToyotaClimateControlBuilder();
    }

    @Test
    void testCreateBasic() {
        ToyotaClimateControl result = builder.createBasic();
        assertTrue(result instanceof BasicToyotaClimateControl);
        assertEquals("Basic Toyota ClimateControl", result.toString());
    }

    @Test
    void testCreateMultiZone() {
        ToyotaClimateControl result = builder.createMultiZone();
        assertTrue(result instanceof MultiZoneToyotaClimateControl);
        assertEquals("Multi-Zone Toyota Climate Control", result.toString());
    }

    @Test
    void testCreateMultiZoneToyotaClimateControlBuilder() {
        ToyotaClimateControlBuilder builder = Mockito.mock(ToyotaClimateControlBuilder.class);
        ToyotaClimateControl expected = new MultiZoneToyotaClimateControl();
        when(builder.createMultiZone()).thenReturn(expected);
        ToyotaClimateControl actual = builder.createMultiZone();
        verify(builder).createMultiZone();
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testCreateBasicToyotaClimateControlBuilder() {
        ToyotaClimateControlBuilder builder = Mockito.mock(ToyotaClimateControlBuilder.class);
        ToyotaClimateControl expected = new BasicToyotaClimateControl();
        when(builder.createBasic()).thenReturn(expected);
        ToyotaClimateControl actual = builder.createBasic();
        verify(builder).createBasic();
        assertEquals(expected.toString(), actual.toString());
    }
}
