package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User ana = new User("Ana", "ceva", 10, 10, 10
            );

            User maria = new User("Maria", "ceva", 10, 10, 10
            );

            //repository.saveAll(List.of(ana,maria));

        };
    }
}
