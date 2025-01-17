package com.example.api_user.service;

import com.example.api_user.model.Course;
import com.example.api_user.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(String title) {
        Course course = new Course();
        course.setTitle(title);
        return courseRepository.save(course);
    }

    public Optional<Course> findCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public void deleteCourse(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Curso não encontrado.");
        }
        courseRepository.deleteById(courseId);
    }

}
