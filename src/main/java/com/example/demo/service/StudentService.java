package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository){
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public Student addStudent(Student student) {
        student.setGroup(groupRepository.findOne(student.getGroupId()));
        return studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void removeStudent(long id) {
        studentRepository.delete(id);
    }

    public List<Student> studentsList() {
        return studentRepository.findAll();
    }
}
