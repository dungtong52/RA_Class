package edu.controller;

import edu.model.dto.response.ApiDataResponse;
import edu.model.dto.response.StudentXML;
import edu.model.entity.Student;
import edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Student>>> getAll(){
        return new ResponseEntity<>(new ApiDataResponse<List<Student>>(
                true,
                "Get list of students successfully!",
                studentService.getStudents(),
                null,
                HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Student>> insertStudent(@RequestBody Student student){
        return new ResponseEntity<>(new ApiDataResponse<>(
           true,
           "Insert student "+student.getFullName()+" successfully!",
           studentService.insertStudent(student),
           null,
           HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @GetMapping(value = "/xml-data", produces = MediaType.APPLICATION_XML_VALUE)
    public StudentXML getAll1(){
        return
                new StudentXML(studentService.getStudents());

    }
}
