package com.example.api_user.controller;

import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.service.CourseService;
import com.example.api_user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Student createStudent(@RequestParam String name) {
        return studentService.createStudent(name);
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public Student enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentService.findStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado."));
        Course course = courseService.findCourseById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado."));
        return studentService.enrollStudentInCourse(student, course);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.findStudentById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado."));
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
