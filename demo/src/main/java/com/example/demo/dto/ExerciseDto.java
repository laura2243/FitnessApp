package com.example.demo.dto;

import lombok.Data;

@Data
public class ExerciseDto {
    private String name;
    private String description;
    private Integer duration;
    private Integer height;
    private Integer kg;
    private Integer age;
}
