package com.example.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;



public class EmailObject implements Event{

    private String toEmail;
    private String subject;
    private String body;

    public EmailObject(String toEmail, String subject, String body) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
    }

    private EmailSenderService senderService;
    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(Object object) {
        senderService.sendEmail("","","");
    }


}
