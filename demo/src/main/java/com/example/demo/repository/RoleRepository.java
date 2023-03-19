package com.example.demo.repository;

import com.example.demo.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


/**
 * Interface that uses JPA to create query methods for pulling specific information about Role objects from the database
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(String name);
}
