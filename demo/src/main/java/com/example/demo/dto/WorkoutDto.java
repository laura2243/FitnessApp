package com.example.demo.dto;

import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class WorkoutDto {

    private String name;


    private Date date_start;


    private Date date_finish;
    private Integer duration;
    private TypeEntity type;


    private List<ExerciseEntity> exercises;

    public WorkoutDto(String name, Date date_start, Date date_finish, Integer duration, TypeEntity type, List<ExerciseEntity> exercises) {

        this.name = name;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.duration = duration;
        this.type = type;
        this.exercises = exercises;
    }

    public WorkoutDto() {
    }
}
