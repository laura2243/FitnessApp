package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeDto {
    private String name;

    public TypeDto(String name) {
        this.name = name;
    }


}
