package com.library.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
@Getter
@Setter
public class Library {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BookItem> books;

    @OneToOne(cascade = CascadeType.ALL)
    private Catalog catalog;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;
}
