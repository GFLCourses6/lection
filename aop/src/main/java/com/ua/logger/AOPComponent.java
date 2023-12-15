package com.ua.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPComponent {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AOPComponent.class);

    @Pointcut(value = "execution(* *.sendMessage(..))")
    public void sendMessagePointCut() {

    }

    @Around(value = "sendMessagePointCut()")
    public Object executeTime(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        LOGGER.info("Time taken: {} milliseconds", (end - start));
        return proceed;
    }

    @Around(value = "sendMessagePointCut() && args(message, params)", argNames = "proceedingJoinPoint,message,params")
    public Object executeTime2(
            ProceedingJoinPoint proceedingJoinPoint,
            String message,
            Integer params)
            throws Throwable {
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        LOGGER.info("Time taken: {} ms {} {}", (end - start), message, params);
        return proceed;
    }

    @Before(value = "sendMessagePointCut() && args(message)")
    public void before(String message) {
        LOGGER.info("Before: {} event", message);
    }

    @AfterReturning(value = "sendMessagePointCut() && args(message)")
    public void after(String message) {
        LOGGER.info("After: {} event", message);
    }

    @AfterThrowing(value = "sendMessagePointCut() && args(message)", throwing = "ex")
    public void afterThrowing(String message, Exception ex) {
        LOGGER.info("After: {} event {}", message, ex.getMessage());
    }
}
