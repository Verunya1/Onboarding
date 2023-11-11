package com.example.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="course_user",
            joinColumns=  @JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="course_id", referencedColumnName="id") )
    private List <User> userId;
    private Long price;
    private String status;
    private Timestamp passageTime;
    private String description;
    private String type;
    private String access;
}
