//package com.example.demo.email;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//
//@Component
//public class NewUserEventListener {
//
//    @Autowired
//    private EmailSenderService emailSenderService;
//
//    @EventListener()
//    public void handleNewUser(final NewUserEvent newUserEvent) throws MessagingException {
//
//      emailSenderService.sendSimpleMail(new EmailObject(newUserEvent.getUserEntity().getEmail(),"subj","body"));
//
//    }
//}
