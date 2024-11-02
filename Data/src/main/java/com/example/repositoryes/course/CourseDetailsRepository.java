package com.example.repositoryes.course;

import com.example.models.course.Course;
import com.example.models.course.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long> {

    @Query("SELECT cd FROM CourseDetails cd WHERE cd.course = :course")
    Optional<CourseDetails> findByCourse(Course course);
}
