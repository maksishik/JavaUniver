package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public void addStudentInGroup(String title) {
        /*aList<Student> studentList = studentRepository.findAll();
        Group group = new Group();
        group.setTitle(title);
        group.setStudent(studentList);*/
    }

    public Group addGroup(Group group) {
        /*List<Student> students = studentRepository.findAll();
        Group group = new Group("1gg");
        group.setStudent(students);
        Student student = new Student("PEtrov");
        student.setGroup(group);*/
        return groupRepository.save(group);
    }
}
