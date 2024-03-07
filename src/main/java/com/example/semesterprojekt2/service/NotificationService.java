package com.example.semesterprojekt2.service;

import java.time.LocalDateTime;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class NotificationService {
    public static void userCreatedNotification(String customerMail) throws MessagingException {
        // Information needed to use the given email to send mails, using the SMTP server
        String host = "smtp.office365.com";
        String port = "587";
        String email = "MonkasBarber@outlook.com";
        String password = "123Monika!";

        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // activating authentication
        props.put("mail.smtp.starttls.enable", "true"); // activvating TLS
        props.put("mail.smtp.host", host); // pointing to the SMTP server
        props.put("mail.smtp.port", port); // pointing to the SMTP port

        // Acknowledge sessionen
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            // From the given mail
            message.setFrom(new InternetAddress(email));
            // To costumer
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerMail));
            // Creates a string to build the message
            StringBuilder messageText = new StringBuilder();

            message.setSubject("Welcome to Monkas Barber");
            messageText.append("Dear " + customerMail + "\n");
            messageText.append("Welcome to Monkas Barber Shop! We're ready to give you a nice haircut whenever you're ready!");

            // adding string builder to the message.
            message.setText(messageText.toString());

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + customerMail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static void mailConfirmationNotification(String customerMail, LocalDateTime reservationTime) throws MessagingException {
        // Information needed to use the given email to send mails, using the SMTP server
        String host = "smtp.office365.com";
        String port = "587";
        String email = "MonkasBarber@outlook.com";
        String password = "123Monika!";

        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // activating authentication
        props.put("mail.smtp.starttls.enable", "true"); // activvating TLS
        props.put("mail.smtp.host", host); // pointing to the SMTP server
        props.put("mail.smtp.port", port); // pointing to the SMTP port

        // Acknowledge sessionen
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            // From the given mail
            message.setFrom(new InternetAddress(email));
            // To costumer
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerMail));
            // Creates a string to build the message
            StringBuilder messageText = new StringBuilder();

                // Title of the mail
            message.setSubject("Confirmation of Your Barber Shop Appointment");

            messageText.append("Dear " + customerMail + "\n");
            messageText.append("We're thrilled to confirm your appointment at Monkas Barber Shop!\n\n");
            messageText.append("Appointment Details:\n");
            messageText.append("Time: " + reservationTime);

            // adding string builder to the message.
            message.setText(messageText.toString());

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + customerMail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}