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

    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    public void addStudentInGroup(Long id, Long studId) {
        Student student = studentRepository.findOne(studId);
        Group group = groupRepository.findOne(id);
        student.setGroup(group);
        studentRepository.save(student);
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    public void removeGroup(Long id) {
        groupRepository.delete(id);
    }
}
