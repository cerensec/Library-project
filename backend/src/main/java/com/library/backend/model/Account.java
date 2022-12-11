package com.library.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "opened")
    private Date opened;

    @OneToOne
    private AccountState state;


    @OneToMany(cascade = CascadeType.ALL)
    private List<BookItem> borrowed;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BookItem> reserved;

}
