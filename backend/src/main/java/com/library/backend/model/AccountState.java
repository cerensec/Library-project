package com.library.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "accountState")
public class AccountState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

}
