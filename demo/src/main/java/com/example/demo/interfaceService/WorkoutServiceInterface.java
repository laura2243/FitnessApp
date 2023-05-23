package com.example.demo.interfaceService;

import com.example.demo.dto.WorkoutDto;
import com.example.demo.entity.WorkoutEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkoutServiceInterface {


    List<WorkoutEntity> getWorkouts();

    WorkoutEntity getWorkoutByName(String name);



    ResponseEntity<String> deleteWorkout(String workoutName);


    ResponseEntity<String> addWorkout(WorkoutDto workoutDto);
}
