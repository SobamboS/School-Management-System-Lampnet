package com.backendtest.lampnetsolutions.controller;

import com.backendtest.lampnetsolutions.dto.CreateCourseRequest;
import com.backendtest.lampnetsolutions.model.Course;
import com.backendtest.lampnetsolutions.service.CourseService;
import com.backendtest.lampnetsolutions.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/course")
public class CourseController{
    CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<?> createCourse(@RequestBody @Valid CreateCourseRequest createCourseRequest,
                                      HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(courseService.createCourse(createCourseRequest))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getCourse")
    public ResponseEntity<?> getCourse(@RequestBody Long id,
                                      HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(courseService.getCourseById(id))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



    @PutMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody @Valid Course course,
                                      HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(courseService.updateCourse(course))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
