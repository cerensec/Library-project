package com.library.backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Librarian {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private FullName fullName;

    @OneToOne
    private Address address;

    @Column(name = "position")
    private String position;
}
