package com.backendtest.lampnetsolutions.repository;

import com.backendtest.lampnetsolutions.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

    Teacher findTeacherByEmail(String email);
    Optional<Teacher> findByEmailIgnoreCase(String email);
}
