package com.example.repositoryes.course.challenges;

import com.example.models.course.Course;
import com.example.models.course.challenges.CourseChallenges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseChallengesRepository extends JpaRepository<CourseChallenges, Long> {
    @Query("SELECT cc FROM CourseChallenges cc WHERE cc.course= :course")
    Optional<List<CourseChallenges>> findByCourse(Course course);

    @Query("SELECT cc FROM CourseChallenges cc WHERE cc.name= :name")
    Optional<CourseChallenges> findByName(String name);
}
