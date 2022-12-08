package com.library.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalog")
@Getter
@Setter
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "catalog",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_item_id")
    )
    private List<BookItem> books;

    @OneToOne(cascade = CascadeType.ALL)
    private Library library;
}
