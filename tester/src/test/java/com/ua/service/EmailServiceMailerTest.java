package com.ua.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmailServiceMailerTest {

    private EmailServiceMailer sentEmail;
    private Transport transport;

    @BeforeEach
    public void setUp()
            throws NoSuchProviderException {
        Session session = mock(Session.class);
        Properties properties = new Properties();
        transport = mock(Transport.class);
        when(session.getTransport("smtp")).thenReturn(transport);
        when(session.getProperties()).thenReturn(properties);
        sentEmail = new EmailServiceMailer();
        sentEmail.setSession(session);
    }

    @Test
    void sendEmailWithTestKeywordShouldInvokeTestCallback() {
        EmailServiceMailer mailer = new EmailServiceMailer();
        Runnable testCallback = mock(Runnable.class);
        mailer.sendEmail("This is a test email", testCallback, null);
        verify(testCallback, times(1)).run();
    }

    @Test
    void sendEmailWithSalaryKeywordShouldInvokeSalaryCallback() {
        EmailServiceMailer emailServiceManager = new EmailServiceMailer();
        Runnable salaryCallback = mock(Runnable.class);
        emailServiceManager.sendEmail("salary", null, salaryCallback);
        verify(salaryCallback, times(1)).run();
    }

    @Test
    void sendEmailWithNoKeywordShouldNotInvokeCallbacks() {
        EmailServiceMailer emailServiceManager = new EmailServiceMailer();
        Runnable testCallback = mock(Runnable.class);
        Runnable salaryCallback = mock(Runnable.class);
        emailServiceManager.sendEmail("Regular email",
                                      testCallback,
                                      salaryCallback);
        verify(testCallback, never()).run();
        verify(salaryCallback, never()).run();
    }

    @Test
    void testSendMail() {
        String emailBody = "salary";
        try (MockedStatic<Transport> mockedTransport = Mockito.mockStatic(
                Transport.class)) {
            sentEmail.sendEmail(emailBody);
            mockedTransport.verify(() -> Transport.send(any(Message.class)));
        }
    }

    @Test
    void sendEmailWithTestKeywordShouldNotSendEmail()
            throws MessagingException {
        String emailBody = "test";
        sentEmail.sendEmail(emailBody);
        verify(transport, never()).sendMessage(any(), any());
    }

    @Test
    void getMessageShouldReturnCorrectMessage()
            throws MessagingException {
        String msg = "This is a test message";
        Message message = sentEmail.getMessage(msg);
        assertEquals("Mail Subject", message.getSubject());
        assertEquals("to@gmail.com",
                     ((InternetAddress) message.getRecipients(Message.RecipientType.TO)[0]).getAddress());
    }

    @Test
    void getMultipartShouldReturnMultipartWithCorrectBodyPart()
            throws MessagingException, IOException {
        String msg = "This is a test message";
        MimeBodyPart mimeBodyPart = sentEmail.getMimeBodyPart(msg);
        Multipart multipart = sentEmail.getMultipart(mimeBodyPart);
        assertEquals(1, multipart.getCount());
        assertEquals(msg, (multipart.getBodyPart(0)).getContent());
    }

    @Test
    void getMimeBodyPartShouldReturnCorrectBodyPart()
            throws MessagingException, IOException {
        String msg = "This is a test message";
        MimeBodyPart mimeBodyPart = sentEmail.getMimeBodyPart(msg);
        assertEquals(msg, mimeBodyPart.getContent());
    }

}

