package com.gfl.prokhnov.singleton.staticBlockInitialization;

import com.gfl.prokhnov.example.patterns.singleton.staticBlockInitialization.StaticBlockInitializationSingleton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Static Block Initialization Singleton Test")
class StaticBlockInitializationSingletonTest {
    @Test
    @DisplayName("Method getInstance() not return NULL")
    void testGetInstanceNotNull() {
        StaticBlockInitializationSingleton instance = StaticBlockInitializationSingleton.getInstance();
        assertNotNull(instance);
    }

    @Test
    @DisplayName("Two instance equals")
    void testTwoInstanceEquals() {
        StaticBlockInitializationSingleton instance1 = StaticBlockInitializationSingleton.getInstance();
        StaticBlockInitializationSingleton instance2 = StaticBlockInitializationSingleton.getInstance();
        assertEquals(instance1, instance2);
    }

}