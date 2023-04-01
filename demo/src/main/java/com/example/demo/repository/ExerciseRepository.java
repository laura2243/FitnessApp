package com.example.demo.repository;

import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Integer> {
    Optional<ExerciseEntity> findUserByName(String name);
}
