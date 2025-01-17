package com.example.api_user.service;

import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.repository.CourseRepository;
import com.example.api_user.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Student createStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

    public Student enrollStudentInCourse(Student student, Course course) {
        student.addCourse(course);
        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Estudante não encontrado.");
        }
        studentRepository.deleteById(studentId);
    }
}
