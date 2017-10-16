package com.example.demo.controller;

import com.example.demo.model.Group;
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

    @PostMapping(value = "/add")
    public Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @GetMapping(value = "/list")
    public List<Group> findAllGroups() {
        return groupService.findAllGroups();
    }
}
