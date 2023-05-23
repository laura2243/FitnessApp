package com.example.demo.dto;

import com.example.demo.entity.RoleEntity;
import lombok.Data;
import org.eclipse.sisu.plexus.Roles;

@Data
public class LoginDto {
    private String username;
    private String password;

    private RoleEntity role;


    public LoginDto(String username, String password, RoleEntity role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public LoginDto() {
    }
}
