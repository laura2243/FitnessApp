package com.example.demo.services;

import com.example.demo.dto.ExerciseDto;
import com.example.demo.entity.ExerciseEntity;
import com.example.demo.interfaceService.ExerciseServiceInterface;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExerciseService implements ExerciseServiceInterface {

    private final ExerciseRepository exerciseRepository;
    private final TypeRepository typeRepository;


    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, TypeRepository typeRepository) {
        this.exerciseRepository = exerciseRepository;
        this.typeRepository = typeRepository;
    }




    public List<ExerciseEntity> getExercises() {
        return exerciseRepository.findAll();
    }


    /**
     * method that deletes an exercise resource
     * if the exercise deleted successfully it modifies the database otherwise
     * a message that the exercise does not exist
     *
     * @return
     */
    public ResponseEntity<String> deleteExercise(Integer exerciseId) {
//        boolean exists = exerciseRepository.existsById(exerciseId);
//        if (!exists) {
//            throw new IllegalStateException("exercise with id" + exerciseId + "does not exists");
//
//        }
        exerciseRepository.findById(exerciseId).orElseThrow(() -> new IllegalStateException("exercise with id " + exerciseId + " does not exist"));

        exerciseRepository.deleteById(exerciseId);
        return new ResponseEntity<>("Exercise deleted successfully!", HttpStatus.OK);

    }


    /**
     * method that updates an exercise's fields
     * if the exercise is update successfully it modifies the database otherwise
     * if the name is already taken an error message will be shown
     * and the changes will not be made
     *
     * @return
     */
    @Transactional
    public ExerciseEntity updateExercise(Integer exerciseId, ExerciseDto newExercise) {
        ExerciseEntity exerciseEntity = exerciseRepository.findById(exerciseId).orElseThrow(() -> new IllegalStateException("exercise with id " + exerciseId + " does not exist"));

        if (newExercise.getName() != null && newExercise.getName().length() > 0 && !Objects.equals(newExercise.getName(), exerciseEntity.getName())) {
            Optional<ExerciseEntity> exerciseOptional = exerciseRepository.findUserByName(newExercise.getName());

            if (exerciseOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            exerciseEntity.setName(newExercise.getName());
        }
        if (newExercise.getDescription() != null && newExercise.getDescription().length() > 0 && !Objects.equals(newExercise.getDuration(), exerciseEntity.getDescription())) {

            exerciseEntity.setDescription(newExercise.getDescription());
        }
        if (newExercise.getHeight() != null && newExercise.getHeight() > 0 && !Objects.equals(newExercise.getHeight(), exerciseEntity.getHeight())) {
            exerciseEntity.setHeight(newExercise.getHeight());
        }
        if (newExercise.getKg() != null && newExercise.getKg() > 0 && !Objects.equals(newExercise.getKg(), exerciseEntity.getKg())) {
            exerciseEntity.setKg(newExercise.getKg());
        }
        if (newExercise.getDuration() != null && newExercise.getDuration() > 0 && !Objects.equals(newExercise.getDuration(), exerciseEntity.getDuration())) {
            exerciseEntity.setDuration(newExercise.getDuration());
        }
        if (newExercise.getAge() != null && newExercise.getAge() > 0 && !Objects.equals(newExercise.getAge(), exerciseEntity.getAge())) {
            exerciseEntity.setAge(newExercise.getAge());
        }

        exerciseRepository.saveAndFlush(exerciseEntity);

        return exerciseEntity;

    }


    /**
     * Method that adds a new exercise in the application
     * if the exercise is added successfully it returns status 200 OK otherwise
     * if the name is taken an error message will be shown and
     * the action will not succeed
     *
     * @param exerciseDto
     * @return ResponseEntity<String>
     */
    public ExerciseEntity addExercise(ExerciseDto exerciseDto) {
        Optional<ExerciseEntity> exerciseOptionalName = exerciseRepository.findUserByName(exerciseDto.getName());
        if (exerciseOptionalName.isPresent()) {
            throw new IllegalStateException("name taken");
        }


        ExerciseEntity exerciseEntity = new ExerciseEntity(exerciseDto.getName(), exerciseDto.getDescription(),
                exerciseDto.getDuration(), exerciseDto.getHeight(), exerciseDto.getKg(),
                exerciseDto.getAge(),exerciseDto.getType());




        exerciseRepository.saveAndFlush(exerciseEntity);

        //return new ResponseEntity<>("Exercise added successfully!", HttpStatus.OK);
        return exerciseEntity;
    }

}
