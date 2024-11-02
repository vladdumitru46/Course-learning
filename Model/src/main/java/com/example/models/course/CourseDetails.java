package com.example.models.course;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CourseDetails")
@Table(name = "courses_details")
@NoArgsConstructor
@Getter
@Setter
public class CourseDetails {
    @Id
    @SequenceGenerator(
            name = "course_details_sequence",
            sequenceName = "course_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_details_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "course_name",
            referencedColumnName = "name"
    )
    private Course course;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "video",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String video;

    @Column(
            name = "tips",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String tips;

    @Column(
            name = "challenges",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String challenges;
}
