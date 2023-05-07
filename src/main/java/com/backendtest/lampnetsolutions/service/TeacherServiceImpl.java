package com.backendtest.lampnetsolutions.service;

import com.backendtest.lampnetsolutions.exception.StudentException;
import com.backendtest.lampnetsolutions.exception.TeacherException;
import com.backendtest.lampnetsolutions.model.Teacher;
import com.backendtest.lampnetsolutions.repository.TeacherRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Slf4j
@Service
@NoArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    TeacherRepository teacherRepository;

    @Override
    public String registerTeacher(Teacher teacher) throws TeacherException{
            if(findByEmailIgnoreCase(teacher.getEmail())
                    .isPresent())
                throw new StudentException(String.format("%s is already used", teacher.getEmail()));
           Teacher teacher1 = new Teacher(
                    teacher.getFirstName(),
                    teacher.getLastName(),
                    teacher.getEmail(),
                    hashPassword(teacher.getPassword()));
            teacherRepository.save(teacher1);
            return ("Registration Successful");
    }
        private String hashPassword (String password){
            return BCrypt.hashpw(password, BCrypt.gensalt());
        }

        private Optional<Teacher> findByEmailIgnoreCase(String email) {
            return teacherRepository.findByEmailIgnoreCase(email);
        }

    @Override
    public String login (Teacher teacher)throws TeacherException{
        var foundUser = teacherRepository.findByEmailIgnoreCase(teacher.getEmail());
        if (foundUser.isEmpty()) throw new TeacherException(String.format("%s is not registered", foundUser));
        if (!BCrypt.checkpw(teacher.getPassword(), foundUser.get().getPassword())) {
            throw new RuntimeException("password does not match");
        }else return "Login Successful";
    }


    @Override
    public Optional<Teacher> getTeacher(Long id) throws TeacherException{
            var findTeacher= teacherRepository.findById(id);
            if(findTeacher.isEmpty()){
                throw new TeacherException(String.format("%s not found",findTeacher));
            }else {
                return findTeacher;
            }
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws TeacherException{
            var existingTeacher = teacherRepository.findById(teacher.getId())
                    .orElseThrow(()-> new StudentException("Student not found"));
            if (existingTeacher != null) {
                existingTeacher.setFirstName(teacher.getFirstName());
                existingTeacher.setLastName(teacher.getLastName());
                existingTeacher.setPassword(teacher.getPassword());
                existingTeacher.setEmail(teacher.getEmail());
                return teacherRepository.save(existingTeacher);
            } else {
                return null;
            }
        }

    @Override
    public boolean deleteTeacher(Long id)throws TeacherException{
            Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(()-> new StudentException("Student not found"));
            if (existingTeacher!= null) {
               teacherRepository.delete(existingTeacher);
                return true;
            } else {
                return false;
            }
    }

    }
