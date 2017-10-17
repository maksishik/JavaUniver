package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    //@JsonProperty("group")
    private Group group;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public Student() {}
}
