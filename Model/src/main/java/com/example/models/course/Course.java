package com.example.models.course;

import com.example.models.course.enums.CourseSubject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "Course")
@Table(name = "course")
@NoArgsConstructor
@Getter
@Setter
public class Course implements Serializable {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String name;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Enumerated(EnumType.STRING)
    private CourseSubject courseSubject;


    public Course(String name, String description, CourseSubject courseSubject) {
        this.name = name;
        this.description = description;
        this.courseSubject = courseSubject;
    }
}
