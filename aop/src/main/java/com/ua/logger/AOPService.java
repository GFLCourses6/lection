package com.ua.logger;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AOPService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPService.class);


    public void sendMessage(String message)
            throws Exception {
        TimeUnit.SECONDS.sleep(1);
        throw new Exception("Log Exception" + message);
    }

    public void sendMessage(
            String message,
            Integer params)
            throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("send Message: {} {}", message, params);
    }

    public void sendMessage(
            String message,
            Boolean params)
            throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        LOGGER.info("send Message with flag: {} {}", message, params);
    }
}
