package com.example.api_user.controller;

import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestParam String name) {
        return studentService.createStudent(name);
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public Student enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.enrollStudentInCourse(studentId, courseId);
    }

    @GetMapping
    public List<Student> listarTodos() {
        return studentService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Student> buscarPorId(@PathVariable Long id) {
        return studentService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public void Studenteditar(@PathVariable Long id, @RequestParam String name) {
        studentService.update(id, name);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        studentService.deletarPorId(id);
    }

}