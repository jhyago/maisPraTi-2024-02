package com.example.api_user.controller;

import com.example.api_user.dto.CourseDTO;
import com.example.api_user.dto.UpdateCourseRequest;
import com.example.api_user.model.Course;
import com.example.api_user.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id){
        return  courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping
    public Optional<CourseDTO> updateName(@RequestBody UpdateCourseRequest request){
        return courseService.updateCourseTitle(request.getId(), request.getTitle());
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

}
