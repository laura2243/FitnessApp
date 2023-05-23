package com.example.demo.repository;

import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface that uses JPA to create query methods for pulling specific information about ExerciseEntity objects from the database
 */
@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Integer> {
    Optional<ExerciseEntity> findExerciseEntityByName(String name);

    @Query("SELECT t FROM ExerciseEntity t where t.type = ?1")
    Optional<ExerciseEntity> findTypeInExercise (String type);

    List<ExerciseEntity> findExerciseEntitiesByType(TypeEntity type);

    List<ExerciseEntity> findExerciseEntitiesByName(String name);

    List<ExerciseEntity> findExerciseEntityByTypeName(String typeName);
}
