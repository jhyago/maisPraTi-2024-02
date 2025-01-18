package com.example.api_user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private Set<Long> studentIds; // Os ids dos estudantes para evitar Recursividade
}
