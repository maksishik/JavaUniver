package com.example.demo.model;

import lombok.Data;
import org.omg.CosNaming.BindingHelper;

import javax.persistence.*;
import javax.persistence.criteria.From;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public Group(String title) {
        this.title = title;
    }

    public Group(){}
}
