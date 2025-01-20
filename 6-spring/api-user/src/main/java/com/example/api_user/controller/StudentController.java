package com.example.api_user.controller;

import com.example.api_user.dto.CourseDTO;
import com.example.api_user.dto.StudentDTO;
import com.example.api_user.dto.UpdateCourseRequest;
import com.example.api_user.dto.UpdateStudentRequest;
import com.example.api_user.model.Course;
import com.example.api_user.model.Student;
import com.example.api_user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDTO> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping
    public Optional<StudentDTO> updateName(@RequestBody UpdateStudentRequest request){
        return studentService.updateStudentName(request.getId(), request.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public Student enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        studentService.enrollStudentToCourse(studentId, courseId);
        return null;
    }


}
