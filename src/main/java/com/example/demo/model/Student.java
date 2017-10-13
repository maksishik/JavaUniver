package com.example.demo.model;

import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /*
    * Сериализация - это преобразование экземпляра класса в форму,
    * пригодную для его сохранения (например в файл, в БД или для передачи по сети).
    * Сериализованные объекты можно затем восстановить (десериализовать).
    * */
   // private transient Long groupId;


    private Long groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId", referencedColumnName = "id", insertable = false, updatable = false)
    private Group group;

    public Student(String name) {
        this.name = name;
    }

    public Student() {}



}
