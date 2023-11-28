package com.ua.service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

import static jakarta.mail.internet.InternetAddress.parse;

public class EmailServiceMailer
        implements EmailService {
    private Session session = getSession();

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void sendEmail(String emailBody) {
        if (emailBody.contains("test")) {
            return;
        }
        if (emailBody.startsWith("salary")) {
            try {
                String msg = "This is my first test email using JavaMailer";
                Transport.send(getMessage(msg));
            } catch (MessagingException e) {
                System.err.println(e.getMessage());
            } finally {
                System.out.println(emailBody);
            }
        }
    }

    protected Message getMessage(String msg)
            throws MessagingException {
        Message message = new MimeMessage(session);
        Multipart multipart = getMultipart(getMimeBodyPart(msg));
        message.setFrom(new InternetAddress("from@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, parse("to@gmail.com"));
        message.setSubject("Mail Subject");
        message.setContent(multipart);
        return message;
    }

    protected Multipart getMultipart(MimeBodyPart mimeBodyPart)
            throws MessagingException {
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        return multipart;
    }

    protected MimeBodyPart getMimeBodyPart(String msg)
            throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        return mimeBodyPart;
    }

    private Session getSession() {
        session = Session.getInstance(getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username", "password");
            }
        });
        return session;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        return properties;
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
