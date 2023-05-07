package com.backendtest.lampnetsolutions.service;

import com.backendtest.lampnetsolutions.dto.CreateCourseRequest;
import com.backendtest.lampnetsolutions.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {
    String createCourse(CreateCourseRequest createCourseRequest);
    Course getCourseById(Long id);
    Course updateCourse( Course course);
    String deleteCourse(Long id);
}
