package com.example.semesterprojekt2.service;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class NotificationService {
    public static void mailNotification(int mailType, String customerMail, String reservationTime) throws MessagingException {
        // Information for at kunne bruge og sende mails fra den givende email, ved brug af SMTP server
        String host = "smtp.office365.com";
        String port = "587";
        String email = "MonkasBarber@outlook.com";
        String password = "123Monika!";

        // Email egenskaber
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Aktivere godkendelse
        props.put("mail.smtp.starttls.enable", "true"); // Aktivere TLS
        props.put("mail.smtp.host", host); // Angivelse af SMTP-server
        props.put("mail.smtp.port", port); // Angivelse af SMTP-port

        // Godkender sessionen
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            // Fra den givende email
            message.setFrom(new InternetAddress(email));
            // Til kunden
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerMail));
            // Opretter en String builder for at opbygge teksten
            StringBuilder messageText = new StringBuilder();

            if(mailType == 1){
                message.setSubject("Welcome to Monkas Barber");
                messageText.append("Dear " + customerMail + "\n");
                messageText.append("Welcome to Monkas Barber Shop! We're ready to give you a nice haircut whenever you're ready!");
            }

            if(mailType == 2){
                // Titlen på mailen
                message.setSubject("Confirmation of Your Barber Shop Appointment");

                messageText.append("Dear " + customerMail + "\n");
                messageText.append("We're thrilled to confirm your appointment at Monkas Barber Shop!\n\n");
                messageText.append("Appointment Details:\n");
                messageText.append("Time: " + reservationTime);
            }

            // Tilføjer String builderen til mail beskeden
            message.setText(messageText.toString());

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + customerMail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}