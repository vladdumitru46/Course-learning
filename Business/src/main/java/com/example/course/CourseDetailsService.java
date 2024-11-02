package com.example.course;

import com.example.models.course.Course;
import com.example.models.course.CourseDetails;
import com.example.repositoryes.course.CourseDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("courseDetails")
@AllArgsConstructor
public class CourseDetailsService {

    private final CourseDetailsRepository courseDetailsRepository;

    public CourseDetails getCourseDetails(Course course) throws Exception {
        return courseDetailsRepository.findByCourse(course)
                .orElseThrow(() -> new Exception("There is no course details for this course"));
    }
}
