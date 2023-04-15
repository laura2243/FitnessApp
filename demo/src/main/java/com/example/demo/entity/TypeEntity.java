package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "types")
public class TypeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public TypeEntity(String name) {
        this.name = name;
    }

    public TypeEntity() {
    }

    public TypeEntity(Integer id) {
        this.id = id;
    }



    public List<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "type")
    private List<ExerciseEntity> exercises;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "type")
    private List<WorkoutEntity> workouts;

    @Override
    public String toString() {
        return "TypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exercises=" + exercises +
                ", workouts=" + workouts +
                '}';
    }
}
