package com.example.api_user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private Set<Long> courseIds; //Ids dos cursos para evitar recursividade
}
