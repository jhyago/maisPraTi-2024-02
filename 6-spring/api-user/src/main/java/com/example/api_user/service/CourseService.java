package com.example.api_user.service;

import com.example.api_user.dto.CourseDTO;
import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.repository.CourseRepository;
import com.example.api_user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getTitle(),
                        course.getStudents().stream().map(Student::getId).collect(Collectors.toSet())
                )).collect(Collectors.toList());
    }

    public Optional<CourseDTO> getCourseById(Long id){
        return courseRepository.findById(id)
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getTitle(),
                        course.getStudents().stream().map(Student::getId).collect(Collectors.toSet())
                ));
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<CourseDTO> updateCourseTitle(Long id, String newTitle){
        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(newTitle);
                    courseRepository.save(course);
                    return new CourseDTO(
                        course.getId(),
                        course.getTitle(),
                        course.getStudents().stream().map(Student::getId).collect(Collectors.toSet())
                    );
                });
    }

    public void deleteCourse(Long id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not Found"));

        course.getStudents().forEach(student -> student.getCourses().remove(course));
        course.getStudents().clear();
        courseRepository.deleteById(id);
    }


}
