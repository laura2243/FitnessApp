package com.example.demo.services;


import com.example.demo.dto.ExerciseDto;
import com.example.demo.dto.WorkoutDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import com.example.demo.entity.WorkoutEntity;
import com.example.demo.interfaceService.WorkoutServiceInterface;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService implements WorkoutServiceInterface {

    private final WorkoutRepository workoutRepository;
    private final TypeRepository typeRepository;
    private final ExerciseRepository exerciseRepository;


    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, TypeRepository typeRepository, ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.typeRepository = typeRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<WorkoutEntity> getWorkouts() {
        return workoutRepository.findAll();
    }


    /**
     * method that deletes a workout resource
     * if the exercise deleted successfully it modifies the database otherwise
     * a message that the workout does not exist
     */
    @Transactional
    public ResponseEntity<String> deleteWorkout(String workoutName) {
//        boolean exists = workoutRepository.existsById(workoutId);
//        if (!exists) {
//            throw new IllegalStateException("workout with id" + workoutId + "does not exists");
//
//        }

        workoutRepository.findWorkoutEntityByName(workoutName).orElseThrow(() -> new IllegalStateException("workout with name" + workoutName + " does not exist"));

        workoutRepository.deleteWorkoutEntityByName(workoutName);
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
        Optional<WorkoutEntity> workoutOptionalName = workoutRepository.findWorkoutEntityByName(workoutDto.getName());
        if (workoutOptionalName.isPresent()) {
            throw new IllegalStateException("name taken");
        }

        //Optional<TypeEntity> typeEntityOptional = typeRepository.findTypeEntityByName(workoutDto.getType().getName());



        List<ExerciseEntity> exerciseEntities = new ArrayList<>();
        for(ExerciseEntity exerciseEntity:workoutDto.getExercises()) {
            Optional<ExerciseEntity> exerciseEntityOptional = exerciseRepository.findExerciseEntityByName(exerciseEntity.getName());
            exerciseEntities.add(exerciseEntityOptional.get());

        }

        WorkoutEntity workoutEntity = new WorkoutEntity(workoutDto.getName(), workoutDto.getDate_start(), workoutDto.getDate_finish(),
                workoutDto.getDuration(),  exerciseEntities);





        workoutRepository.save(workoutEntity);

        return new ResponseEntity<>("Workout added successfully!", HttpStatus.OK);
    }


    public WorkoutEntity getWorkoutByName(String name) {
        return workoutRepository.findWorkoutEntityByName(name).get();
    }







    }
