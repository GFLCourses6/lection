package com.ua.service;

public class EmailServiceManager
        implements EmailService {

    @Override
    public void sendEmail(String emailBody) {
        if (emailBody.contains("test")) {
            return;
        }
        if (emailBody.startsWith("salary")) {
            System.out.println(emailBody);
        }
    }

    public void sendEmail(
            String emailBody,
            Runnable testCallback,
            Runnable salaryCallback) {
        if (emailBody.contains("test") && (testCallback != null)) {
            testCallback.run();
            return;
        }
        if (emailBody.contains("salary") && (salaryCallback != null)) {
            salaryCallback.run();
        }
        System.out.println(emailBody);
    }
}
