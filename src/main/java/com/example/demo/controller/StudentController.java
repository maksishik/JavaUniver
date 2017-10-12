package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping(produces = "application/json")
    public List<Student> findAllStudents(){
        return studentService.studentsList();
    }
}
