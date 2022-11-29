package com.library.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "format")
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
