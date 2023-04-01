package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

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


    public ExerciseEntity( String name, String description, Integer duration, Integer height, Integer kg, Integer age) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.height = height;
        this.kg = kg;
        this.age = age;
    }

    public ExerciseEntity() {
    }

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "typeID",referencedColumnName = "id")
    private TypeEntity type;


    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "workoutID",referencedColumnName = "id")
    private WorkoutEntity workout;


}
