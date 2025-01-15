package com.example.api_user.service;

import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.repository.CourseRepository;
import com.example.api_user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Student createStudent (String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

    public Course createCourse (String title){
        Course course = new Course();
        course.setTitle(title);
        return courseRepository.save(course);
    }

    public Student enrollStudentInCourse(Long studentId, Long courseId){
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if(studentOpt.isPresent() && courseOpt.isPresent()){
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.addCourse(course);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Estudante ou curso não encontrado.");
        }
    }
}
