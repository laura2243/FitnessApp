package com.example.demo.services;


import com.example.demo.dto.WorkoutDto;
import com.example.demo.entity.WorkoutEntity;
import com.example.demo.interfaceService.WorkoutServiceInterface;
import com.example.demo.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService implements WorkoutServiceInterface {

    private final WorkoutRepository workoutRepository;


    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }


    public List<WorkoutEntity> getWorkouts() {
        return workoutRepository.findAll();
    }


    /**
     * method that deletes a workout resource
     * if the exercise deleted successfully it modifies the database otherwise
     * a message that the workout does not exist
     */
    public ResponseEntity<String> deleteWorkout(Integer workoutId) {
//        boolean exists = workoutRepository.existsById(workoutId);
//        if (!exists) {
//            throw new IllegalStateException("workout with id" + workoutId + "does not exists");
//
//        }

        workoutRepository.findById(workoutId).orElseThrow(() -> new IllegalStateException("workout with id " + workoutId + " does not exist"));

        workoutRepository.deleteById(workoutId);
        return new ResponseEntity<>("Workout deleted successfully!", HttpStatus.OK);
    }


    /**
     * Method that adds a new workout in the application
     * if the workout is added successfully it returns status 200 OK otherwise
     * if the name is taken an error message will be shown and
     * the action will not succeed
     *
     * @param workoutDto
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> addWorkout(WorkoutDto workoutDto) {
        Optional<WorkoutEntity> workoutOptionalName = workoutRepository.findUserByName(workoutDto.getName());
        if (workoutOptionalName.isPresent()) {
            throw new IllegalStateException("name taken");
        }


        WorkoutEntity workoutEntity = new WorkoutEntity(workoutDto.getName(), workoutDto.getDate_start(), workoutDto.getDate_finish(),
                workoutDto.getDuration(), workoutDto.getType(), workoutDto.getExercises());


        workoutRepository.saveAndFlush(workoutEntity);

        return new ResponseEntity<>("Workout added successfully!", HttpStatus.OK);
    }

}
