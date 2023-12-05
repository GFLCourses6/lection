package com.gfl.prokhnov.singleton.eagerInitialization;

import com.gfl.prokhnov.example.patterns.singleton.eagerInitialization.EagerInitializationSingleton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("EaGer Initialization Singleton Test")
class EagerInitializationSingletonTest {

    @Test
    @DisplayName("Method getInstance() not return NULL")
    void testGetInstanceNotNull() {
        EagerInitializationSingleton instance = EagerInitializationSingleton.getInstance();
        assertNotNull(instance);
    }

    @Test
    @DisplayName("Two instance equals")
    void testTwoInstanceEquals() {
        EagerInitializationSingleton instance1 = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton instance2 = EagerInitializationSingleton.getInstance();
        assertEquals(instance1, instance2);
    }
}