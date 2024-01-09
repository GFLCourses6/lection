package org.example.aop;

import org.springframework.stereotype.Service;

import java.awt.font.TextMeasurer;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleService {

    public void sendMessage(String message) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        throw new Exception("Test message");
    }

    public void sendMessage(String message, Integer param) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    public void sendMessage(String message, Boolean param) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }
}
