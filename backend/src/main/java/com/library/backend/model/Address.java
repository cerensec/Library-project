package com.library.backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Address {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "zip")
    private String zip;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "street")
    private String street;
}
