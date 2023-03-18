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
}
