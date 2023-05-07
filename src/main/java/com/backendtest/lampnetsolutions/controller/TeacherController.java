package com.backendtest.lampnetsolutions.controller;

import com.backendtest.lampnetsolutions.model.Teacher;
import com.backendtest.lampnetsolutions.service.TeacherService;
import com.backendtest.lampnetsolutions.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController{
    TeacherService teacherService;

        @PostMapping("/register/teacher")
        public ResponseEntity<?> registerTeacher(@RequestBody @Valid Teacher teacher,
                                                 HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(teacherService.registerTeacher(teacher))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }

        @PutMapping("/{id}/getTeacher")
        public ResponseEntity<?> getTeacher(@PathVariable @Valid Long id,
                                            HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(teacherService.getTeacher(id))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }


        @PutMapping("/update")
        public ResponseEntity<?> updateTeacher(@RequestBody @Valid Teacher teacher,
                                               HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(teacherService.updateTeacher(teacher))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }

        @PutMapping("/login")
        public ResponseEntity<?> login(@RequestBody @Valid Teacher teacher,
                                       HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(teacherService.login(teacher))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }



        @DeleteMapping("/{id}/deleteTeacher")
        public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
            boolean deleted = teacherService.deleteTeacher(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
