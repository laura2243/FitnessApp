package com.example.demo.user;
import com.example.demo.models.Role;
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

}