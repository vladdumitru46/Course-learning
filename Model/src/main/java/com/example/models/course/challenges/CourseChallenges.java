package com.example.models.course.challenges;

import com.example.models.course.Course;
import com.example.models.course.challenges.types.ChallengeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "CourseChallenges")
@Table(name = "course_challenges")
@NoArgsConstructor
@Getter
@Setter
public class CourseChallenges {
    @Id
    @SequenceGenerator(
            name = "CourseChallenges_sequence",
            sequenceName = "CourseChallenges_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CourseChallenges_sequence"
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
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "course_name",
            referencedColumnName = "name"
    )
    private Course course;

    @Column(
            name = "challenges",
            nullable = false,
            columnDefinition = "bytea[]"
    )
    private List<ChallengeType> challenges;

    public CourseChallenges(String name, String description, Course course, List<ChallengeType> challenges) {
        this.name = name;
        this.description = description;
        this.course = course;
        this.challenges = challenges;
    }
}
