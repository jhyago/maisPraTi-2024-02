package com.example.api_user.service;

import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.repository.CourseRepository;
import com.example.api_user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Student> listarTodos() {
        return studentRepository.findAll();
    }

    public Optional<Student> buscarPorId(Long id) {
        return studentRepository.findById(id);
    }

    public void update(Long id, String name) {
        studentRepository.findById(id).ifPresent(student -> {
                student.setName(name);
                studentRepository.save(student);
        });
    }

    public void deletarPorId(Long id) {
        studentRepository.deleteById(id);
    }

}
