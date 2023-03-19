package com.example.demo.controllers;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The class that is responsible for processing incoming REST API requests for the interaction with the user,
 * converts the JSON parameter to a user object, and it sends it to the service layer.
 */
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * method that handles the api call for returning all users
     * it calls the method from the service package
     */
    @GetMapping
    public List<UserEntity> getUser() {
        return userService.getUsers();
    }

    /**
     * method that handles the api call for deleting a user
     * it calls the method from the service package
     */
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }


    /**
     * method that handles the api call for updating a user
     * it calls the method from the service package
     */
    @PutMapping(path = "{userId}")
    public  void updateUser( @PathVariable("userId") Integer userId, @RequestBody RegisterDto userEntity){
        userService.updateUser(userId, userEntity);
    }


}
