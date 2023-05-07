package com.example.demo;

import com.example.demo.dto.WorkoutDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import com.example.demo.entity.WorkoutEntity;
import com.example.demo.interfaceService.WorkoutServiceInterface;
import com.example.demo.repository.TypeRepository;
import com.example.demo.repository.WorkoutRepository;
import com.example.demo.services.WorkoutService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WorkoutTests {


    @Mock
    private WorkoutRepository workoutRepository;



    @Test
    public void shouldSaveWorkout() {

        WorkoutServiceInterface workoutServiceInterface = new WorkoutService(workoutRepository);

        List<ExerciseEntity> exercises = new ArrayList<ExerciseEntity>();
        exercises.add(new ExerciseEntity("name", "description", 5, 5, 5, 5));
        SimpleDateFormat dateStart = new SimpleDateFormat("2002-01-01");

        WorkoutDto workoutDto = new WorkoutDto("name", dateStart, dateStart, 10, new TypeEntity("type"),
                exercises);


        when(workoutRepository.save(any(WorkoutEntity.class))).thenReturn(new WorkoutEntity());


        WorkoutEntity workoutEntityFromDto = new WorkoutEntity();
        BeanUtils.copyProperties(workoutDto, workoutEntityFromDto);


        ResponseEntity<String> resultRespons = workoutServiceInterface.addWorkout(workoutDto);
        assertEquals(resultRespons.getStatusCode(), HttpStatus.OK);
        verify(workoutRepository).saveAndFlush(workoutEntityFromDto);


    }

    @Test
    public void getAllWorkout_success() {

        WorkoutServiceInterface workoutServiceInterface = new WorkoutService(workoutRepository);

        List<ExerciseEntity> exercises = new ArrayList<ExerciseEntity>();
        exercises.add(new ExerciseEntity("name", "description", 5, 5, 5, 5));
        SimpleDateFormat dateStart = new SimpleDateFormat("2002-01-01");

        WorkoutEntity workoutEntity = new WorkoutEntity("name", dateStart, dateStart, 10, new TypeEntity("type"),
                exercises);
        WorkoutEntity workoutEntity2 = new WorkoutEntity("name", dateStart, dateStart, 10, new TypeEntity("type"),
                exercises);

        List<WorkoutEntity> workouts = new ArrayList<>(Arrays.asList(
                workoutEntity, workoutEntity2
        ));

        when(workoutRepository.findAll()).thenReturn(workouts);

        List<WorkoutEntity> workoutEntities = workoutServiceInterface.getWorkouts();

        assertEquals(workoutEntities, workouts);
        verify(workoutRepository).findAll();
    }


    @Test
    void shouldDeleteWorkout() {

        WorkoutServiceInterface workoutServiceInterface = new WorkoutService(workoutRepository);

        List<ExerciseEntity> exercises = new ArrayList<ExerciseEntity>();
        exercises.add(new ExerciseEntity("name", "description", 5, 5, 5, 5));
        SimpleDateFormat dateStart = new SimpleDateFormat("2002-01-01");

        WorkoutEntity workoutEntity = new WorkoutEntity(1, "name", dateStart, dateStart, 10, new TypeEntity("type"),
                exercises);

        when(workoutRepository.findById(workoutEntity.getId())).thenReturn(Optional.of(workoutEntity));
        ResponseEntity<String> resultResponse = workoutServiceInterface.deleteWorkout(workoutEntity.getId());

        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);
        verify(workoutRepository).deleteById(workoutEntity.getId());

    }


}
