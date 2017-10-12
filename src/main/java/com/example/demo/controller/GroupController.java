package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    private GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(value = "/add")
    public void addStudentInGroup(@RequestParam(value = "id") Long id,
                                   @RequestParam(value = "studentId") Long studentId) {
        groupService.addStudentInGroup(id, studentId);
    }

    @PostMapping(value = "/test")
    private List<Integer> test() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);

        return integers;
    }
}
