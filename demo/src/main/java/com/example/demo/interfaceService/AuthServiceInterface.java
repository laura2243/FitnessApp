package com.example.demo.interfaceService;

import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.email.NewUserEvent;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 interface used for low coupling for AuthService
 it contains the methods from mservice */
public interface AuthServiceInterface {

   ResponseEntity<String> register(RegisterDto registerDto) ;
    ResponseEntity<AuthResponseDto> login(LoginDto loginDto) ;
}
