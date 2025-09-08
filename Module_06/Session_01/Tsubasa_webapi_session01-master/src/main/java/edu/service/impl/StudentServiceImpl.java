package edu.service.impl;

import edu.model.entity.Student;
import edu.repo.StudentRepo;
import edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElseThrow(()->new NoSuchElementException("Khong ton tai student co id: "+id));
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        studentRepo.findById(student.getStudentId()).orElseThrow(()->new NoSuchElementException("Khong ton tai student co id: "+student.getStudentId()));
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepo.findById(id).orElseThrow(()->new NoSuchElementException("Khong ton tai student co id: "+id));
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepo.findAllByFullNameContains(name);
    }
}
