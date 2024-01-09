package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class SimepleAOPComponent {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimepleAOPComponent.class);
    private final JPAService jpaService;

    public SimepleAOPComponent(JPAService jpaService) {
        this.jpaService = jpaService;
    }

    @Pointcut(value = "execution(* *.sendMessage(..))")
    public void sendMessagePointCut() {
    }

    @Around(value = "sendMessagePointCut() && args(message)")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint, String message) throws Throwable {
        long start = System.nanoTime();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        LOGGER.info(String.format("Execution time (%s) - %s", message, TimeUnit.NANOSECONDS.toMillis(end - start)));
        return proceed;
    }

    @Before(value = "sendMessagePointCut() && args(message)")
    public void before(String message) {
        LOGGER.info("Before execution");
    }

    @AfterReturning(value = "sendMessagePointCut() && args(message)")
    public void after(String message) {
        LOGGER.info("After execution");
        jpaService.save();
    }

    @AfterThrowing(value = "sendMessagePointCut() && args(message)", throwing = "ex")
    public void afterTh(String message, Exception ex) {
        LOGGER.info("Throw exception - " + ex.getMessage());
        jpaService.save();
    }
}
