package com.example.demo.dto;

import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import lombok.Data;

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
}
