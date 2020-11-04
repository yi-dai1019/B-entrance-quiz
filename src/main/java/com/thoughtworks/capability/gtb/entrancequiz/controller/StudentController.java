package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    //TODO GTB-知识点: - POST 时 path 变成的单数了？
    //TODO GTB-知识点: - 了解一下 @ResponseStatus
    @PostMapping("/student")
    public ResponseEntity<HttpStatus> addStudent(@RequestBody String name) {

        studentService.addStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
