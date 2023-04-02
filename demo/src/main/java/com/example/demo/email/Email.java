package com.example.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;


import java.util.Properties;

/**
 * class for setting up necessary details about the email
 */
@Component
public class Email {


    @Autowired
    private JavaMailSender mailSender;


    /**
     * method that sets up the properties required for sending the email
     *
     * @return mailSender
     */
    private static JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("writersworkspace430@gmail.com");
        mailSender.setPassword("dvuykvktpwimyvqh");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    /**
     * method that sets up the subject, body and sender for the email
     *
     * @param to
     * @param subject
     * @param text
     */
    public static void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("writersworkspace430@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        getJavaMailSender().send(message);
    }

}




