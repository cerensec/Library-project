package com.library.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("BookItem")
public class BookItem extends Book {

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "tag")
    private String tag;

    @Column(name = "title")
    private String title;

    @Column(name = "is_reference_only")
    private boolean isReferenceOnly;

    @OneToOne
    private Langue langue;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @OneToOne
    private Format format;

    @Column(name = "borrowed")
    private Date borrowed;

    @Column(name = "loan_period")
    private int loanPeriod;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "is_overdue")
    private Boolean isOverdue;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        isReferenceOnly = referenceOnly;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getOverdue() {
        return isOverdue;
    }

    public void setOverdue(Boolean overdue) {
        isOverdue = overdue;
    }
}
