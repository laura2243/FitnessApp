package com.example.demo.user;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            UserEntity ana = new UserEntity("Ana", "ceva", 10, 10, 10,"username1","parola1"
            );

            UserEntity maria = new UserEntity("Maria", "ceva", 10, 10, 10,"userename2","parola2"
            );

            //repository.saveAll(List.of(ana,maria));

        };
    }
}
