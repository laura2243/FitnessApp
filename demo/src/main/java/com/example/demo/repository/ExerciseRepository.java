package com.example.demo.repository;

import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that uses JPA to create query methods for pulling specific information about ExerciseEntity objects from the database
 */
@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Integer> {
    Optional<ExerciseEntity> findUserByName(String name);
}
