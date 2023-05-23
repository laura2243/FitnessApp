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
    @CrossOrigin
    @GetMapping
    public List<WorkoutEntity> getWorkouts() {
        return workoutService.getWorkouts();
    }

    /**
     * method that handles the api call for deleting a workout
     * it calls the method from the service package
     */
    @CrossOrigin
    @DeleteMapping("delete")
    public void deleteWorkout(String workoutName) {
        workoutService.deleteWorkout(workoutName);
    }



    /**
     * method that handles the api call for adding a workout
     * it calls the method from the service package
     */
    @CrossOrigin
    @PostMapping("addWorkout")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutDto workoutDto) {
        return workoutService.addWorkout(workoutDto);
    }



    @CrossOrigin
    @GetMapping("getWorkoutByName")
    public WorkoutEntity getWorkoutByName(String name) {
        String typet = "ceva ";
        typet += workoutService.getWorkoutByName(name).getExercises().get(0).getType().getName();
        System.out.println(typet);
        return workoutService.getWorkoutByName(name);
    }




}
