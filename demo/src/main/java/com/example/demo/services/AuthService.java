package com.example.demo.services;

import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.email.EmailObject;
import com.example.demo.email.Event;
import com.example.demo.entity.RoleEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTGenerator;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator jwtGenerator;
    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private Event event;


    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                       JWTGenerator jwtGenerator, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.authenticationManager = authenticationManager;
    }


    /**
     * Method that registers a new user in the application
     * if the user registers successfully it returns status 200 OK otherwise
     * if the username or the email is taken an error message will be shown and
     * the registration will not succeed
     * @param registerDto
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> register(RegisterDto registerDto) {
        Optional<UserEntity> userOptionalEmail = userRepository.findUserByEmail(registerDto.getEmail());
        Optional<UserEntity> userOptionalUsername = userRepository.findUserByUsername(registerDto.getUsername());
        if (userOptionalEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        if (userOptionalUsername.isPresent()) {
            throw new IllegalStateException("username taken");
        }

        UserEntity userEntity = new UserEntity(registerDto.getName(), registerDto.getEmail(), registerDto.getHeight(), registerDto.getKg(), registerDto.getAge(), registerDto.getUsername(), passwordEncoder.encode(registerDto.getPassword()));

        RoleEntity roles = roleRepository.findByName("USER").get();
        userEntity.setRole(roles);

        userRepository.saveAndFlush(userEntity);

      //  EmailObject emailObject = new EmailObject(userEntity.getEmail(),"Registration","Registration completed!");

       // event.sendMail(emailObject);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);


    }


    /**
     * Method for login of a user that already has an account in the application
     * if the user logins successfully it returns status 200 OK and a token otherwise
     * if the username or password are incorrect  it returns status 401 Unauthorized
     *@param loginDto
     *@return AuthResponseDto
     */
    public ResponseEntity<AuthResponseDto> login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }
}
