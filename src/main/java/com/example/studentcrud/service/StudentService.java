package com.example.studentcrud.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    public List<Student> searchByName(String keyword) {
        return studentRepository.findByNameContaining(keyword);
    }

    public Optional<Student> updateStudent(int id, Student updatedData){
        Optional<Student> existingOpt = studentRepository.findById(id);
        if (existingOpt.isPresent()) {
            Student existingStudent = existingOpt.get();

            existingStudent.setName(updatedData.getName());
            existingStudent.setEmail(updatedData.getEmail());
            existingStudent.setCourse(updatedData.getCourse());
            existingStudent.setPhone(updatedData.getPhone());

            Student saved = studentRepository.save(existingStudent);
            return Optional.of(saved);
        }
        return Optional.empty();
    }

    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public long getTotalStudents() {
        return studentRepository.count();
    }
}
