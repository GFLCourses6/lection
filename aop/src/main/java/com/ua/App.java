package com.ua;

import com.ua.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@Import(AppConfig.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private static void run() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.close();
    }
}
