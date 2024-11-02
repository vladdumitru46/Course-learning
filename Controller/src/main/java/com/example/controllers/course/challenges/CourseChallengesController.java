package com.example.controllers.course.challenges;

import com.example.course.CourseService;
import com.example.course.challenges.CourseChallengesService;
import com.example.models.course.Course;
import com.example.models.course.challenges.CourseChallenges;
import com.example.models.course.challenges.types.ChallengeType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courseChallenges")
@CrossOrigin(origins = "*")
public class CourseChallengesController {

    private final CourseChallengesService courseChallengesService;
    private final CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllChallenges(@RequestParam String courseName) {
        try {
            Course course = courseService.getByName(courseName);
            List<CourseChallenges> courseChallenges = courseChallengesService.getByCourse(course);
            return new ResponseEntity<>(courseChallenges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String name) {
        try {
            CourseChallenges courseChallenges = courseChallengesService.getByName(name);
            return new ResponseEntity<>(courseChallenges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByChallengeTypeName")
    public ResponseEntity<?> getByChallengeTypeName(@RequestParam String challengeName, @RequestParam String challengeTypeName) {
        try {
            CourseChallenges courseChallenges = courseChallengesService.getByName(challengeName);
            ChallengeType challengeType = courseChallengesService.getByChallengeTypeName(courseChallenges, challengeTypeName);
            return new ResponseEntity<>(challengeType, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
