package com.example.api_user.controller;

import com.example.api_user.model.Course;
import com.example.api_user.service.CourseService;
import com.example.api_user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public Course createCourse(@RequestParam String title){
        return courseService.createCourse(title);
    }

    @GetMapping
    public List<Course> listarTodos() {
        return courseService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Course> buscarPorId(@PathVariable Long id) {
        return courseService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public void courseEditar(@PathVariable Long id, @RequestParam String title) {
        courseService.update(id, title);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        courseService.deletarPorId(id);
    }

}
