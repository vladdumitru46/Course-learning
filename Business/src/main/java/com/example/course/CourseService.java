package com.example.course;

import com.example.models.course.Course;
import com.example.repositoryes.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getByName(String name) throws Exception {
        return courseRepository.findByName(name)
                .orElseThrow(()->new Exception("There is no course with that name"));
    }
}
