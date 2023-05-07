package com.example.demo.interfaceService;

import com.example.demo.dto.WorkoutDto;
import com.example.demo.entity.WorkoutEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutServiceInterface {


    List<WorkoutEntity> getWorkouts();

    ResponseEntity<String> deleteWorkout(Integer workoutId);


    ResponseEntity<String> addWorkout(WorkoutDto workoutDto);
}
