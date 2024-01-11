package com.ua.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class ScheduleComponent {

    private final AtomicInteger count = new AtomicInteger(1);
    private final Lock countLock = new ReentrantLock();

    @Scheduled(fixedRateString = "${fixed.daily.rate}", initialDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedRateSchedule() throws InterruptedException {
        print();
        TimeUnit.SECONDS.sleep(4);
        incrementCount();
    }

    @Async("asyncTaskExecutor")
    @Scheduled(fixedDelay = 1, initialDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedDelaySchedule() throws InterruptedException {
        print();
        TimeUnit.SECONDS.sleep(3);
        incrementCount();
    }

    private void print() {
        System.out.printf("#%s Just do it %s at %s %n",
                          count,
                          Thread.currentThread().getName(),
                          LocalDateTime.now());
    }

    private void incrementCount() {
        countLock.lock();
        try {
            count.incrementAndGet();
        } finally {
            countLock.unlock();
        }
    }

    public int getCount() {
        return count.get();
    }
}