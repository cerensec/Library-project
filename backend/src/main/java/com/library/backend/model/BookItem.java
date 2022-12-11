package com.library.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("BookItem")
@Getter
@Setter
public class BookItem extends Book {

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "tag")
    private String tag;

    @Column(name = "title")
    private String title;

    @Column(name = "is_reference_only")
    private boolean isReferenceOnly;

    @OneToOne(cascade = CascadeType.ALL)
    private Langue langue;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @OneToOne(cascade = CascadeType.ALL)
    private Format format;

    @Column(name = "borrowed")
    private Date borrowed;

    @Column(name = "loan_period")
    private int loanPeriod;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "is_overdue")
    private Boolean isOverdue;



}
