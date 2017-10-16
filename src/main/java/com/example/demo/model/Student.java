package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String name) {
        this.name = name;
    }

    public Student() {}

    /*
    * Сериализация - это преобразование экземпляра класса в форму,
    * пригодную для его сохранения (например в файл, в БД или для передачи по сети).
    * Сериализованные объекты можно затем восстановить (десериализовать).
    * */
    //private transient Long groupId;

}
