package com.backendtest.lampnetsolutions.service;

import com.backendtest.lampnetsolutions.model.Student;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public interface StudentService{
    String createStudent(Student student);
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
    String login (Student student);

}
