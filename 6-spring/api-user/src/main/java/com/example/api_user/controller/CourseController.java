package com.example.api_user.controller;

import com.example.api_user.model.Course;
import com.example.api_user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public Course createCourse(@RequestParam String title){
        return studentService.createCourse(title);
    }
}
