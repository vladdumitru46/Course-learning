package com.example.controllers.course;

import com.example.course.challenges.CourseChallengesService;
import com.example.models.course.Course;
import com.example.models.course.CourseDetails;
import com.example.course.CourseDetailsService;
import com.example.course.CourseService;
import com.example.models.course.challenges.CourseChallenges;
import com.example.response.CourseDetailsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courseDetails")
@CrossOrigin(origins = "*")
public class CourseDetailsController {

    private final CourseService courseService;
    private final CourseDetailsService courseDetailsService;
    private final CourseChallengesService courseChallengesService;

    @GetMapping()
    public ResponseEntity<?> getCourseDetails(@RequestParam String courseName) {
        try {
            Course course = courseService.getByName(courseName);
            CourseDetails courseDetails = courseDetailsService.getCourseDetails(course);
            List<CourseChallenges> courseChallenges = courseChallengesService.getByCourse(course);
            List<String> courseChallengesNames = courseChallenges.stream()
                    .map(CourseChallenges::getName)
                    .toList();
            CourseDetailsResponse courseDetailsResponse = new CourseDetailsResponse(courseDetails.getDescription(), courseDetails.getVideo(), courseDetails.getTips(), courseChallengesNames);
            return new ResponseEntity<>(courseDetailsResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
