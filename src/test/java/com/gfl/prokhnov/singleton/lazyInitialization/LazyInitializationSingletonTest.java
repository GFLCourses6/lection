package com.gfl.prokhnov.singleton.lazyInitialization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Lazy Initialization Singleton Tests")
class LazyInitializationSingletonTest {

    @Test
    @DisplayName("Method getInstance() not return NULL")
    void testGetInstanceNotNull() {
        LazyInitializationSingleton instance = LazyInitializationSingleton.getInstance();
        assertNotNull(instance);
    }

    @Test
    @DisplayName("Two instance equals")
    void testTwoInstanceEquals() {
        LazyInitializationSingleton instance1 = LazyInitializationSingleton.getInstance();
        LazyInitializationSingleton instance2 = LazyInitializationSingleton.getInstance();
        assertEquals(instance1, instance2);
    }

}