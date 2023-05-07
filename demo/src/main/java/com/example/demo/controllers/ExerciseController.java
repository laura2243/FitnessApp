package com.example.demo.controllers;


import com.example.demo.dto.ExerciseDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.interfaceService.ExerciseServiceInterface;
import com.example.demo.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The class that is responsible for processing incoming REST API requests for the interaction with the exercises,
 * converts the JSON parameter to an exercise object, and it sends it to the service layer.
 */
@RestController
@RequestMapping(path = "api/exercise")
public class ExerciseController {

    private final ExerciseServiceInterface exerciseService;

    @Autowired
    public ExerciseController(ExerciseServiceInterface exerciseService) {
        this.exerciseService = exerciseService;
    }

    /**
     * method that handles the api call for returning all exercises
     * it calls the method from the service package
     */
    @GetMapping
    public List<ExerciseEntity> getExercises() {
        return exerciseService.getExercises();
    }

    /**
     * method that handles the api call for deleting an exercise
     * it calls the method from the service package
     */
    @DeleteMapping(path = "{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseService.deleteExercise(exerciseId);
    }


    /**
     * method that handles the api call for updating an exercise
     * it calls the method from the service package
     */
    @PutMapping(path = "{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer exerciseId, @RequestBody ExerciseDto exerciseDto) {
        exerciseService.updateExercise(exerciseId, exerciseDto);
    }

    /**
     * method that handles the api call for adding an exercise
     * it calls the method from the service package
     */
    @PostMapping
    public ExerciseEntity addExercise(@RequestBody ExerciseDto exerciseDto) {

        return exerciseService.addExercise(exerciseDto);
    }


}
