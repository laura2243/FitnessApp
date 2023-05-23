//package com.example.demo;
//
//import com.example.demo.dto.ExerciseDto;
//import com.example.demo.entity.ExerciseEntity;
//import com.example.demo.entity.TypeEntity;
//import com.example.demo.interfaceService.ExerciseServiceInterface;
//import com.example.demo.repository.ExerciseRepository;
//import com.example.demo.repository.TypeRepository;
//import com.example.demo.services.ExerciseService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.BeanUtils;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//
//@SpringBootTest
//class ExerciseTests {
//
//
//    @Mock
//    private ExerciseRepository exerciseRepository;
//
//    @Mock
//    private TypeRepository typeRepository;
//
//
//    @Test
//    public void shouldSaveExercise() {
//
//        ExerciseServiceInterface exerciseServiceInterface = new ExerciseService(exerciseRepository, typeRepository);
//
//        //ExerciseDto exerciseDto = new ExerciseDto("name", "description", 5, 5, 5, 5, new TypeEntity("type"));
//
//        ExerciseDto exerciseDto = new ExerciseDto("name",  new TypeEntity("type"));
//
//        when(exerciseRepository.save(any(ExerciseEntity.class))).thenReturn(new ExerciseEntity());
//
//        ExerciseEntity exerciseEntitySaved = exerciseServiceInterface.addExercise(exerciseDto);
//
//        ExerciseEntity exerciseEntityFromDto = new ExerciseEntity();
//        BeanUtils.copyProperties(exerciseDto, exerciseEntityFromDto);
//        assertEquals(exerciseEntitySaved, exerciseEntityFromDto);
//
//        verify(exerciseRepository).saveAndFlush(exerciseEntityFromDto);
//    }
//
//    @Test
//    public void getAllExercices_success() {
//
//        ExerciseServiceInterface exerciseServiceInterface = new ExerciseService(exerciseRepository, typeRepository);
//
////        ExerciseEntity exerciseEntity = new ExerciseEntity("name", "description", 5, 5, 5, 5);
////        ExerciseEntity exerciseEntity2 = new ExerciseEntity("name1", "description1", 5, 5, 5, 5);
//
//        ExerciseEntity exerciseEntity = new ExerciseEntity("name" );
//        ExerciseEntity exerciseEntity2 = new ExerciseEntity("name1");
//
//
//        List<ExerciseEntity> exercises = new ArrayList<>(Arrays.asList(exerciseEntity, exerciseEntity2));
//
//        when(exerciseRepository.findAll()).thenReturn(exercises);
//
//        List<ExerciseEntity> exerciseEntities = exerciseServiceInterface.getExercises();
//
//        assertEquals(exerciseEntities, exercises);
//        verify(exerciseRepository).findAll();
//    }
//
//    @Test
//    void shouldUpdateExercise() {
//
//        ExerciseServiceInterface exerciseServiceInterface = new ExerciseService(exerciseRepository, typeRepository);
//
////        ExerciseEntity exerciseEntity = new ExerciseEntity("name", "description", 5, 5, 5, 5);
////
////        ExerciseDto exerciseDtoUpdate = new ExerciseDto("usernameUpdate", "descriptionUpdate", 10, 10, 10, 10, new TypeEntity("type"));
//
//        ExerciseEntity exerciseEntity = new ExerciseEntity("name");
//        ExerciseDto exerciseDtoUpdate = new ExerciseDto("usernameUpdate",  new TypeEntity("type"));
//
//        when(exerciseRepository.save(exerciseEntity)).thenReturn(exerciseEntity);
//        when(exerciseRepository.findById(exerciseEntity.getId())).thenReturn(Optional.of(exerciseEntity));
//
//        ExerciseEntity exerciseUpdated = exerciseServiceInterface.updateExercise(exerciseEntity.getId(), exerciseDtoUpdate);
//
//        assertEquals(exerciseDtoUpdate.getName(), exerciseUpdated.getName());
//        verify(exerciseRepository).findById(exerciseEntity.getId());
//
//
//    }
//
//    @Test
//    void shouldDeleteUser() {
//
//        ExerciseServiceInterface exercisesServiceInterface = new ExerciseService(exerciseRepository, typeRepository);
//
//        ExerciseEntity exerciseEntity = new ExerciseEntity("name",  new TypeEntity("type"));
//        ExerciseEntity exerciseEntity = new ExerciseEntity("name", "description", 5, 5, 5, 5, new TypeEntity("type"));
//
//
//
//        when(exerciseRepository.findById(exerciseEntity.getId())).thenReturn(Optional.of(exerciseEntity));
//        ResponseEntity<String> resultResponse = exercisesServiceInterface.deleteExercise(exerciseEntity.getId());
//
//        assertEquals(resultResponse.getStatusCode(), HttpStatus.OK);
//        verify(exerciseRepository).deleteById(exerciseEntity.getId());
//
//    }
//
//}
//
