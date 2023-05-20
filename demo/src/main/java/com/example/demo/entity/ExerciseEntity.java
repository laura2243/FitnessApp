package com.example.demo.entity;


import com.example.demo.dto.TypeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "exercises")
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Integer duration;
    private Integer height;
    private Integer kg;
    private Integer age;

    @ManyToMany
    private List<WorkoutEntity> workout;


    public ExerciseEntity( String name, String description, Integer duration, Integer height, Integer kg, Integer age) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.height = height;
        this.kg = kg;
        this.age = age;
    }

    public ExerciseEntity( String name, String description, Integer duration, Integer height, Integer kg, Integer age, TypeEntity type) {

        this.name = name;
        this.description = description;
        this.duration = duration;
        this.height = height;
        this.kg = kg;
        this.age = age;
        this.type = type;
    }



    public ExerciseEntity(Integer id, String name, String description, Integer duration, Integer height, Integer kg, Integer age, List<WorkoutEntity> workout, TypeEntity type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.height = height;
        this.kg = kg;
        this.age = age;
        this.workout = workout;
        this.type = type;
    }

    public ExerciseEntity(Integer id, String name, String description, Integer duration, Integer height, Integer kg, Integer age, TypeEntity type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.height = height;
        this.kg = kg;
        this.age = age;
        this.type = type;
    }

    public ExerciseEntity() {
    }

    public ExerciseEntity(String name) {

        this.name = name;
    }

    @JsonBackReference
    public TypeEntity getType() {
        return type;
    }




    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "typeID",referencedColumnName = "id", nullable = false)
    private TypeEntity type;



//    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "workoutID",referencedColumnName = "id")
//    private WorkoutEntity workout;


}
