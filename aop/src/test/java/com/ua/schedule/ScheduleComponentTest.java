package com.ua.schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ScheduleComponentTest {

    private final ScheduleComponent scheduleComponent = new ScheduleComponent();

    @Test
    void testFixedRateSchedule()
            throws InterruptedException {
        int initialCount = scheduleComponent.getCount();
        scheduleComponent.fixedRateSchedule();
        int newCount = scheduleComponent.getCount();
        assertTrue(newCount > initialCount);
    }

    @Test
    void testFixedDelaySchedule()
            throws InterruptedException {
        int initialCount = scheduleComponent.getCount();
        scheduleComponent.fixedDelaySchedule();
        int newCount = scheduleComponent.getCount();
        assertTrue(newCount > initialCount);
    }
}
