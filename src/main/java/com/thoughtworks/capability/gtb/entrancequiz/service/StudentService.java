package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        //TODO GTB-工程实践: - allStudent 是多余的
        List<Student> allStudent = studentRepository.findAll();
       return allStudent;
    }

    public void addStudent(String name) {
        studentRepository.addStudent(name);
    }
}
