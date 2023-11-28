package com.ua.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmailServiceManagerTest {

    private Runnable testCallback;
    private Runnable salaryCallback;
    private EmailServiceManager manager;

    @BeforeEach
    void setUp() {
        manager = new EmailServiceManager();
        testCallback = mock(Runnable.class);
        salaryCallback = mock(Runnable.class);
    }

    @Test
    void testSendEmailContainsTest() {
        manager.sendEmail("This is a test email", testCallback, salaryCallback);
        verify(salaryCallback, never()).run();
        verify(testCallback, times(1)).run();
    }

    @Test
    void testSendEmailNoTestAndSalary() {
        manager.sendEmail("This is a test and salary email",
                          testCallback,
                          salaryCallback);
        verify(testCallback, times(1)).run();
        verify(salaryCallback, never()).run();
    }

    @Test
    void testSendEmailStartWithSalary() {
        manager.sendEmail("salary This is email", testCallback, salaryCallback);
        verify(testCallback, never()).run();
        verify(salaryCallback, times(1)).run();
    }

    @Test
    void testSendEmailNoTestOrSalary() {
        manager.sendEmail("test this is a big email",
                          testCallback,
                          salaryCallback);
        verify(testCallback, times(1)).run();
        verify(salaryCallback, never()).run();
    }

    @Test
    void testSendEmailNullCallbacks() {
        EmailServiceManager emailServiceManager = new EmailServiceManager();
        emailServiceManager.sendEmail("This is a email", null, null);
        verify(testCallback, never()).run();
        verify(salaryCallback, never()).run();
    }
}
