package com.gfl.prokhnov.singleton.threadSafe;

import com.gfl.prokhnov.example.patterns.singleton.threadSafe.ThreadSafeSingleton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Thread Safe Singleton Test")
class ThreadSafeSingletonTest {
    @Test
    @DisplayName("Method getInstance() not return NULL")
    void testGetInstanceNotNull() {
        ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance("Test");
        assertNotNull(instance);
    }

    @Test
    @DisplayName("Two instance equals")
    void testTwoInstanceEquals() {
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance("Test");
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance("Test");
        assertEquals(instance1, instance2);
    }
}