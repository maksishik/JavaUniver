package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/group")
public class GroupController {
    private GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public void addStudentsInGroup(@RequestParam(value = "id") Long id,
                                   @RequestParam(value = "students")List<Student> studentList) {
        groupService.addStudentsInGroup(id);
    }
}
