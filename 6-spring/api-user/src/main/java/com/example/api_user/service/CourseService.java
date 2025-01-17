package com.example.api_user.service;

import com.example.api_user.model.Course;
import com.example.api_user.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse (String title){
        Course course = new Course();
        course.setTitle(title);
        return courseRepository.save(course);
    }

    public List<Course> listarTodos() {
        return courseRepository.findAll();
    }

    public Optional<Course> buscarPorId(Long id) {
        return courseRepository.findById(id);
    }

    public void update(Long id, String title) {
        courseRepository.findById(id).ifPresent(course -> {
            course.setTitle(title);
            courseRepository.save(course);
        });
    }

    public void deletarPorId(Long id) {
        this.courseRepository.deleteById(id);
    }

}
