package com.example.api_user.service;

import com.example.api_user.dto.CourseDTO;
import com.example.api_user.dto.StudentDTO;
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
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<StudentDTO> getAllStudents(){
        return studentRepository.findAll().stream()
                .map(student -> new StudentDTO(
                        student.getId(),
                        student.getName(),
                        student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentById(Long id){
        return  studentRepository.findById(id)
                .map(student -> new StudentDTO(
                        student.getId(),
                        student.getName(),
                        student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                ));
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<StudentDTO> updateStudentName(Long id, String newName){
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newName);
                    studentRepository.save(student);
                    return new StudentDTO(
                            student.getId(),
                            student.getName(),
                            student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                    );
                });
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public void enrollStudentToCourse(Long studentId, Long courseId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.addCourse(course);
        studentRepository.save(student);
    }

}
