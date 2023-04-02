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
}
