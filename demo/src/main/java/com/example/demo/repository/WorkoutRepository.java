package com.example.demo.repository;

import com.example.demo.entity.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Interface that uses JPA to create query methods for pulling specific information about WorkoutEntity objects from the database
 */
@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Integer> {

    Optional<WorkoutEntity> findWorkoutEntityByName(String name);



    int deleteWorkoutEntityByName(String name);



}
