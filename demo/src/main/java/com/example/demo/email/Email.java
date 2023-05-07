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
    private JavaMailSenderImpl mailSender;

    public Email(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;

    }

    public Email() {
    }

    /**
     * method that sets up the properties required for sending the email
     *
     * @return mailSender
     */
    public static JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("writersworkspace430@gmail.com");
        mailSender.setPassword("dvuykvktpwimyvqh");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "localhost");
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
    public void sendSimpleMessage(
            String to, String subject, String text)  {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("writersworkspace430@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);


        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();



        prepEmail(mailSender).send(message);



    }

    public JavaMailSenderImpl prepEmail(JavaMailSenderImpl mailSender){
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

    public void sendEmail(SimpleMailMessage message, JavaMailSenderImpl mailSender){
        mailSender.send(message);
    }


}




