package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.model.Student;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    private GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/list")
    public List<Group> findAllGroups() {
        return groupService.findAllGroups();
    }

    @PostMapping(value = "/add")
    public Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @PostMapping(value = "/add-student/{id}/{studId}")
    public void addStudentByIdInGroup(@PathVariable(value = "id") Long id,
                                      @PathVariable(value = "studId") Long studentId) {
        groupService.addStudentInGroup(id, studentId);
    }

    @PutMapping(value = "/update")
    public void updateGroup(@RequestBody Group group) {
        groupService.updateGroup(group);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteGroup(@PathVariable(value = "id") Long id) {
        groupService.removeGroup(id);
    }
}
