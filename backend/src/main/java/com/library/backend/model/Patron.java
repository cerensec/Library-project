package com.library.backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Patron {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private FullName fullName;

    @OneToOne
    private Address address;
}
