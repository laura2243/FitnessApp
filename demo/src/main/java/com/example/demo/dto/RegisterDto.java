package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String name;
    private String email;
    private Integer height;
    private Integer kg;
    private Integer age;

    public RegisterDto(String username, String password, String name, String email, Integer height, Integer kg, Integer age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.height = height;
        this.kg = kg;
        this.age = age;
    }

    public RegisterDto() {
    }
}
