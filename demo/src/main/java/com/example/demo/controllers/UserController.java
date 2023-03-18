package com.example.demo.controllers;

import com.example.demo.user.UserEntity;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUser() {
        return userService.getUsers();
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public  void updateUser( @PathVariable("userId") Integer userId, @RequestBody UserEntity userEntity){
        userService.updateUser(userId, userEntity);
    }


}
