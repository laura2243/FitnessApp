package com.example.demo.controllers;


import com.example.demo.dto.ExerciseDto;
import com.example.demo.dto.WorkoutDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.WorkoutEntity;
import com.example.demo.interfaceService.WorkoutServiceInterface;
import com.example.demo.services.ExerciseService;
import com.example.demo.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/workout")
public class WorkoutController {

    private final WorkoutServiceInterface workoutService;

    @Autowired
    public WorkoutController(WorkoutServiceInterface workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * method that handles the api call for returning all workouts
     * it calls the method from the service package
     */
    @GetMapping
    public List<WorkoutEntity> getWorkouts() {
        return workoutService.getWorkouts();
    }

    /**
     * method that handles the api call for deleting a workout
     * it calls the method from the service package
     */
    @DeleteMapping(path = "{workoutId}")
    public void deleteWorkout(@PathVariable("workoutId") Integer workoutId) {
        workoutService.deleteWorkout(workoutId);
    }



    /**
     * method that handles the api call for adding a workout
     * it calls the method from the service package
     */
    @PostMapping("addWorkout")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutDto workoutDto) {

        return workoutService.addWorkout(workoutDto);
    }



}
