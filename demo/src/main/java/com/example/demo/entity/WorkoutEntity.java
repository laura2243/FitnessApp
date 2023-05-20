package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "workouts")
public class WorkoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_finish;
    private Integer duration;



    public WorkoutEntity( String name, Date date_start, Date date_finish, Integer duration, TypeEntity type, List<ExerciseEntity> exercises) {
        this.name = name;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.duration = duration;
        this.type = type;
        this.exercises = exercises;
    }

    public WorkoutEntity(Integer id, String name, Date date_start, Date date_finish, Integer duration, TypeEntity type, List<ExerciseEntity> exercises) {
        this.id = id;
        this.name = name;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.duration = duration;
        this.type = type;
        this.exercises = exercises;
    }

    public WorkoutEntity() {
    }

    public List<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }

    @JsonBackReference
    public TypeEntity getType() {
        return type;
    }

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "typeID",referencedColumnName = "id")
    private TypeEntity type;

//    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "workout")
//    private List<ExerciseEntity> exercises;
//

    @ManyToMany
    @JoinTable(
            name = "workout_exercises",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    List<ExerciseEntity> exercises;

    @Override
    public String toString() {
        return "WorkoutEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_start=" + date_start +
                ", date_finish=" + date_finish +
                ", duration=" + duration +
                ", type=" + type +
                ", exercises=" + exercises +
                '}';
    }
}
