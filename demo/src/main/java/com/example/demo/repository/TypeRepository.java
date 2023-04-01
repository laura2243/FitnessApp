package com.example.demo.repository;


import com.example.demo.entity.ExerciseEntity;
import com.example.demo.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that uses JPA to create query methods for pulling specific information about TypeEntity objects from the database
 */
@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {
    Optional<TypeEntity> findUserByName(String name);
}
