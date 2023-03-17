package com.example.demo.user;
import jakarta.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "users" )
public class User {
    @Id
//    @SequenceGenerator(
//            name = "user_sequence",
//            sequenceName = "user_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private Long id;
    private String name;
    private String email;
    private Integer height;
    private Integer kg;
    private Integer age;

    public User(Long id,
                String name,
                String email,
                Integer height,
                Integer kg,
                Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.height = height;
        this.kg = kg;
        this.age = age;
    }

    public User(String name, String email, Integer height, Integer kg, Integer age) {
        this.name = name;
        this.email = email;
        this.height = height;
        this.kg = kg;
        this.age = age;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getKg() {
        return kg;
    }

    public void setKg(Integer kg) {
        this.kg = kg;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}