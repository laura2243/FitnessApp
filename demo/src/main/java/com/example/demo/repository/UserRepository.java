package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that uses JPA to create query methods for pulling specific information about UserEntity objects from the database
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

   Optional<UserEntity> findUserByUsername(String username);

   Optional<UserEntity> findUserEntityByUsername(String username);


   int deleteUserEntityByUsername(String username);

   Boolean existsByUsername(String username);
@Query("SELECT s FROM UserEntity s where s.email = ?1")
   Optional<UserEntity> findUserByEmail(String email);
}


