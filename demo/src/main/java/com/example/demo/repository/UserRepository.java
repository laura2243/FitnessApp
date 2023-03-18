package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

   Optional<UserEntity> findUserByUsername(String username);
   Boolean existsByUsername(String username);
@Query("SELECT s FROM UserEntity s where s.email = ?1")
   Optional<UserEntity> findUserByEmail(String email);
}


