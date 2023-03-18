package com.example.demo.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class AuthResponseDto {


    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
