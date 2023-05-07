package com.backendtest.lampnetsolutions.service;

import com.backendtest.lampnetsolutions.exception.TeacherException;
import com.backendtest.lampnetsolutions.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TeacherService{
    String registerTeacher(Teacher teacher);
    Optional<Teacher> getTeacher(Long id);
    Teacher updateTeacher(Teacher teacher);
    boolean deleteTeacher(Long id);
    String login (Teacher teacher) throws TeacherException;
}
