package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "workouts")
public class WorkoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date_start;
    private Date date_finish;
    private Integer duration;

    public WorkoutEntity(Integer id, Date date_start, Date date_finish, Integer duration, TypeEntity type, Set<ExerciseEntity> exercises) {
        this.id = id;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.duration = duration;
        this.type = type;
        this.exercises = exercises;
    }

    public WorkoutEntity() {
    }

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "typeID",referencedColumnName = "id")
    private TypeEntity type;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "workout")
    private Set<ExerciseEntity> exercises;




}
