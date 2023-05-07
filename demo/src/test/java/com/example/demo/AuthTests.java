package com.example.demo;

import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.email.NewUserEvent;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTGenerator;
import com.example.demo.services.AuthService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class AuthTests {


    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private JWTGenerator jwtGenerator;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;


    @Test
    public void registerUser() {
        AuthService authService = new AuthService(userRepository, roleRepository, passwordEncoder, jwtGenerator, authenticationManager, applicationEventPublisher);

        RoleEntity roleEntity = new RoleEntity(1, "USER");

        RegisterDto registerDto = new RegisterDto("username", "password", "name", "email", 5, 5, 5);

        when(userRepository.save(any(UserEntity.class))).thenReturn(new UserEntity());
        when(roleRepository.findByName("USER")).thenReturn(Optional.of(roleEntity));
        var event = mock(NewUserEvent.class);
        doNothing().when(applicationEventPublisher).publishEvent(event);


        ResponseEntity<String> resultResponse = authService.register(registerDto);

        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);

        //verify(userRepository).saveAndFlush(registerDto);
    }




    @Test
    public void loginUser() {
        AuthService authService = new AuthService(userRepository, roleRepository, passwordEncoder,
                jwtGenerator, authenticationManager, applicationEventPublisher);

        UserEntity userEntity = new UserEntity("ana", "ana", 5, 5, 5, "username", "password");


        LoginDto loginDto = new LoginDto("username", "password");

        UsernamePasswordAuthenticationToken principal = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                loginDto.getPassword());

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(principal);

        when(userRepository.findUserByUsername(loginDto.getUsername())).thenReturn(Optional.of(userEntity));


        SecurityContextHolder.getContext().setAuthentication(principal);

        ResponseEntity<AuthResponseDto> resultResponse = authService.login(loginDto);

        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);
        verify(userRepository).findUserByUsername(loginDto.getUsername());

    }


}

