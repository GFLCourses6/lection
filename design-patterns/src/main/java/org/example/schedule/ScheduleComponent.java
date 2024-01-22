package org.example.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduleComponent {


    @Async // асинхронный запуск скедуалара
    // fixedRateString = "${fixed.delay.rate}", initialDelay = 5000
    //@Scheduled(fixedRate =  1000, initialDelay = 5000) // fixedRate - запускает запланированный метод каждые n mileseconds, он не проверяет наличие предыдущих запусков - то есть он будет все равно запускать каждую сек
    public void fixedRateSchedule() throws InterruptedException { // fixedDaily - уже проверяет начиличие предыдуших запусков, то есть он будет ждать на окончание предыдущей таски и будет запускать некст
        // fixedDelayString - можно передать значение с проперти файла
        // initialDelay - когда мы хочешь запускать наш каждыую секунду после старта апки через 5 сек - ждет 5 сек и потом каждую сек
        String countWork  = "Do some part of work fixed Rate %s at time %s";
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
        TimeUnit.SECONDS.sleep(5);

    }

    @Async
   //@Scheduled(fixedDelay =  1000) // fixedRate - запускает запланированный метод каждые n mileseconds, он не проверяет наличие предыдущих запусков - то есть он будет все равно запускать каждую сек
    public void fixedDelaySchedule() throws InterruptedException { // fixedDaily - уже проверяет начиличие предыдуших запусков, то есть он будет ждать на окончание предыдущей таски и будет запускать некст
        // fixedDelayString - можно передать значение с проперти файла
        // initialDelay - когда мы хочешь запускать наш каждыую секунду после старта апки через 5 сек - ждет 5 сек и потом каждую сек
        String countWork  = "Do some part of work fixed Delay %s at time %s";
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(String.format(countWork, Thread.currentThread().getName(), localDateTime));
        TimeUnit.SECONDS.sleep(5);

    }
}
