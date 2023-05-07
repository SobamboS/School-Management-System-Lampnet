package com.backendtest.lampnetsolutions.service;


import com.backendtest.lampnetsolutions.exception.StudentException;
import com.backendtest.lampnetsolutions.model.Student;
import com.backendtest.lampnetsolutions.repository.StudentRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@NoArgsConstructor
public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository;
    @Override
    public String createStudent(Student student)throws StudentException{
   if(findByEmailIgnoreCase(student.getEmail())
           .isPresent())
       throw new StudentException(String.format("%s is already used", student.getEmail()));
   Student student1 = new Student(
           student.getFirstName(),
           student.getLastName(),
           student.getEmail(),
         hashPassword(student.getPassword()));
        studentRepository.save(student1);
        return ("Registration Successful");
    }
    private String hashPassword (String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private Optional<Student> findByEmailIgnoreCase(String email) {
        return studentRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public String login (Student student)throws StudentException{
        var foundUser = studentRepository.findByEmailIgnoreCase(student.getEmail());
        if (foundUser.isEmpty()) throw new StudentException(String.format("%s is not registered", foundUser));
        if (!BCrypt.checkpw(student.getPassword(), foundUser.get().getPassword())) {
                 throw new RuntimeException("password does not match");
             }else return "Login Successful";
    }

    @Override
    public Optional<Student> getStudentById(Long id)throws StudentException{
        var findStudent = studentRepository.findById(id);
        if(findStudent.isEmpty()){
            throw new StudentException(String.format("%s not found",findStudent));
        }else {
            return findStudent;
        }
    }
   @Override
    public Student updateStudent(Long id, Student student)throws StudentException  {
        var existingStudent = studentRepository.findById(id)
                .orElseThrow(()-> new StudentException("Student not found"));
        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setPassword(student.getPassword());
            existingStudent.setEmail(student.getEmail());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteStudent(Long id) throws StudentException{
        Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new StudentException("Student not found"));
        if (existingStudent != null) {
            studentRepository.delete(existingStudent);
            return true;
        } else {
            return false;
        }
    }

}
