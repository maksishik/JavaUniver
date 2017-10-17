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

    @GetMapping(value = "/list")
    public List<Student> findAllStudents(){
        return studentService.studentsList();
    }

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping(value = "/update")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeStudent(@PathVariable("id") Long id) {
        studentService.removeStudent(id);
    }
}
