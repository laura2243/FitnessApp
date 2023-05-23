package com.example.demo.interfaceService;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface {

    List<UserEntity> getUsers();
    UserEntity updateUser(Integer userId, RegisterDto newUserEntity);
    ResponseEntity<String> deleteUser(String username);
}
