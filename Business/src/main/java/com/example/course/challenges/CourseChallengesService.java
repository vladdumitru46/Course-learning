package com.example.course.challenges;

import com.example.models.course.Course;
import com.example.models.course.challenges.CourseChallenges;
import com.example.models.course.challenges.types.ChallengeType;
import com.example.repositoryes.course.challenges.CourseChallengesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseChallengesService {

    private final CourseChallengesRepository courseChallengesRepository;

    public void add(CourseChallenges courseChallenges) {
        courseChallengesRepository.save(courseChallenges);
    }

    public List<CourseChallenges> getByCourse(Course course) throws Exception {
        return courseChallengesRepository.findByCourse(course)
                .orElseThrow(() -> new Exception("There are no challenges for this course"));
    }

    public CourseChallenges getByName(String name) throws Exception {
        return courseChallengesRepository.findByName(name)
                .orElseThrow(() -> new Exception("There are no challenges with this name"));
    }

    public ChallengeType getByChallengeTypeName(CourseChallenges courseChallenges, String challengeTypeName) throws Exception {
        return courseChallenges.getChallenges().stream()
                .filter(challenge -> challenge.getName().equals(challengeTypeName))
                .findFirst()
                .orElseThrow(()->new Exception("There is no challenge type with that name"));
    }
}
