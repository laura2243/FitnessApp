package com.example.demo.controllers;

import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.interfaceService.AuthServiceInterface;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTGenerator;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * The class that is responsible for processing incoming REST API requests for login and register, converts
 * the JSON parameter to a user object, and it sends it to the service layer.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthServiceInterface authService;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    /**
     * method that handles the api call for login
     * it calls the method from the service package
     */
    @CrossOrigin
    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
       return authService.login(loginDto);

    }


    /**
     * method that handles the api call for register
     * it calls the method from the service package
     */
    @CrossOrigin
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {

        return authService.register(registerDto);
    }
}
