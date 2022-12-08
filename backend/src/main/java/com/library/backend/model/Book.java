package com.library.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "book_item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="Book")
@Getter
@Setter
public abstract class Book {
    @Id
    private String isbn;

    @Column(name = "name")
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "subject")
    private String subject;

    @Column(name = "overview")
    private String overview;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publication_date")
    private Date publicationDate;

}
