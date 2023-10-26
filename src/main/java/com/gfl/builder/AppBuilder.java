package com.gfl.builder;

import com.gfl.builder.stepbuilder.Mail;

import java.time.LocalDateTime;

public class AppBuilder {

    public static void main(String[] args) {
        AppBuilder app = new AppBuilder();
        app.run();
    }

    private void run() {
        // Builder pattern (Joshua Bloch's approach):
        Car car1 = Car.builder("BMW", "M5", "Red", 70000d).build();
        Car car2 = Car.builder("Mercedes", "C63", "Black", 75000d)
                .setDoors(4)
                .setGps("Nice GPS")
                .setYear(2022)
                .setHasClimateControl(true)
                .setHasSunroof(true)
                .build();

        System.out.println(car1);
        System.out.println(car2);

        // Step builder pattern:
        Mail mail = Mail.builder()
                .setTitle("Title")
                .setBody("Body")
                .setSenderId("ID12345")
                .setReceiverId("ID54321")
                .setLocalDateTime(LocalDateTime.now()) // optionally
                .build();

        System.out.println(mail);
    }
}
