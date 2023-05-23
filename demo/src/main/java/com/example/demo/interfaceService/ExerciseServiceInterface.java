package com.example.demo.interfaceService;

import com.example.demo.dto.ExerciseDto;
import com.example.demo.dto.TypeDto;
import com.example.demo.entity.ExerciseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExerciseServiceInterface {

    List<ExerciseEntity> getExercises();

    ResponseEntity<String> deleteExercise(Integer exerciseId);

    ExerciseEntity updateExercise(Integer exerciseId, ExerciseDto newExercise);


    ExerciseEntity addExercise(ExerciseDto exerciseDto);

    List<ExerciseEntity> getExercisesByType(TypeDto typeDto);

}
