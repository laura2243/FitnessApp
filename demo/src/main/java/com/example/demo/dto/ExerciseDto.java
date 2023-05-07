package com.example.demo.dto;

import com.example.demo.entity.TypeEntity;
import lombok.Data;

@Data
public class ExerciseDto {
    private String name;
    private String description;
    private Integer duration;
    private Integer height;
    private Integer kg;
    private Integer age;
    private TypeEntity type;

    public ExerciseDto(String name, String description, Integer duration, Integer height, Integer kg, Integer age, TypeEntity type) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.height = height;
        this.kg = kg;
        this.age = age;
        this.type = type;
    }
}
