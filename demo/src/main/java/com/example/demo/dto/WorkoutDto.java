package com.example.demo.dto;

import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.List;

@Data
public class WorkoutDto {

    private String name;
    private SimpleDateFormat date_start;
    private SimpleDateFormat date_finish;
    private Integer duration;
    private TypeEntity type;


    private List<ExerciseEntity> exercises;

    public WorkoutDto(String name, SimpleDateFormat date_start, SimpleDateFormat date_finish, Integer duration, TypeEntity type, List<ExerciseEntity> exercises) {
        this.name = name;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.duration = duration;
        this.type = type;
        this.exercises = exercises;
    }
}
