package com.example.demo.email;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**  class that represents the listener of the event
 */
@Component
public class NewUserEventListener {

    /** method that consumes a NewUserEvent event and is triggered when a user registers
     * @param newUserEvent
     * */
    @EventListener()
    public void handleNewUser(final NewUserEvent newUserEvent)  {

      Email.sendSimpleMessage(newUserEvent.getUserEntity().getEmail(),"Fitness App Registration ","Welcome to your Fitness App, " + newUserEvent.getUserEntity().getName() + "!");

    }
}
