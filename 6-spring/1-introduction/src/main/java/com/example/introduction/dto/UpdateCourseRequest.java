package com.example.introduction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateCourseRequest {
    private Long id;
    private String title;

}

