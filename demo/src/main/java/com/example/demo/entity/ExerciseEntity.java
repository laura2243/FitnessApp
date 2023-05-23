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
    private String gifUrl;



    @ManyToMany
    private List<WorkoutEntity> workout;




    public ExerciseEntity( String name, TypeEntity type) {

        this.name = name;
        this.type = type;
    }

    public ExerciseEntity(Integer id, String gifUrl, String name, List<WorkoutEntity> workout, TypeEntity type) {
        this.id = id;
        this.gifUrl = gifUrl;
        this.name = name;
        this.workout = workout;
        this.type = type;
    }

    public ExerciseEntity(Integer id, String name, List<WorkoutEntity> workout, TypeEntity type) {
        this.id = id;
        this.name = name;
        this.workout = workout;
        this.type = type;
    }

    public ExerciseEntity(Integer id, String name,  TypeEntity type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public ExerciseEntity() {
    }

    public ExerciseEntity(String name) {

        this.name = name;
    }

    public ExerciseEntity(String name, String gifUrl, List<WorkoutEntity> workout, TypeEntity type) {
        this.name = name;
        this.gifUrl = gifUrl;
        this.workout = workout;
        this.type = type;
    }

    public ExerciseEntity(String name, String gifUrl,  TypeEntity type) {
        this.name = name;
        this.gifUrl = gifUrl;
        this.workout = workout;
        this.type = type;
    }



//    @JsonBackReference
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
