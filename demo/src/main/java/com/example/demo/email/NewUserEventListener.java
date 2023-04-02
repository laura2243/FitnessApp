package com.example.demo.email;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class NewUserEventListener {

    @EventListener()
    public void handleNewUser(final NewUserEvent newUserEvent)  {



      Email.sendSimpleMessage(newUserEvent.getUserEntity().getEmail(),"Fitness App Registration ","Welcome to your Fitness App, " + newUserEvent.getUserEntity().getName() + "!");

    }
}
