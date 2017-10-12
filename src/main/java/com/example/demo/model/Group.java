package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.From;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(targetEntity = Student.class, mappedBy = "group", fetch = FetchType.LAZY)
    //@JoinColumn(name = "group_id")
    private Set<Student> student;

    public Group(String title) {
        this.title = title;
    }

    public Group(){}
}
