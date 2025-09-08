package edu.service;

import edu.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudentById(Integer id);
    Student insertStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudentById(Integer id);
    List<Student> getStudentsByName(String name);
}
