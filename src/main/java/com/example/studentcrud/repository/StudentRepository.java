package com.example.studentcrud.repository;

import com.example.studentcrud.model.Student;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCourse(String course);

    List<Student> findByNameContaining(String keyword);

    Optional<Student> findByEmail(String email);

    List<Student> findByCourseOrderByName(String course);
}