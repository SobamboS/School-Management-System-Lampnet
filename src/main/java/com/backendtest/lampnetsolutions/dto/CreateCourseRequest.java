package com.backendtest.lampnetsolutions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCourseRequest{
    private String courseName;
    private String description;
    private int courseCode;
}
