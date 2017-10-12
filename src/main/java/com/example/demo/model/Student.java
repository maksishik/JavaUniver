package com.example.demo.model;

import lombok.Data;

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
    private transient Long groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String name) {
        this.name = name;
    }

    public Student() {}



}
