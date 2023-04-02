package com.example.demo.email;

import com.example.demo.entity.UserEntity;
import org.springframework.context.ApplicationEvent;


/** placeholder class to store the event data
 * */
public class NewUserEvent extends ApplicationEvent {

    private UserEntity userEntity;

    public NewUserEvent(final Object source, final UserEntity userEntity) {
        super(source);
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
