package com.example.demo.dto;

import com.example.demo.entity.TypeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExerciseDto {
    private String name;
    private TypeEntity type;
    private String gifUrl;

    public ExerciseDto(String name, TypeEntity type) {
        this.name = name;
        this.type = type;
    }

    public ExerciseDto(String name) {
        this.name = name;
    }

    public ExerciseDto(String name, TypeEntity type, String gifUrl) {
        this.name = name;
        this.type = type;
        this.gifUrl = gifUrl;
    }
}
