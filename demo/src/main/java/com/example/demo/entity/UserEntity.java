package com.example.demo.entity;
import com.example.demo.models.RoleEntity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "users" )
public class UserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private Integer id;
    private String name;
    private String email;
    private Integer height;
    private Integer kg;
    private Integer age;

    private String username;
    private String password;
    public UserEntity(Integer id,
                      String name,
                      String email,
                      Integer height,
                      Integer kg,
                      Integer age, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.height = height;
        this.kg = kg;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public UserEntity(String name, String email, Integer height, Integer kg, Integer age, String username, String password) {
        this.name = name;
        this.email = email;
        this.height = height;
        this.kg = kg;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public UserEntity() {

    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", kg=" + kg +
                ", age=" + age +
                '}';
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userWorkout",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id"))
    private List<WorkoutEntity> workouts = new ArrayList<>();

}