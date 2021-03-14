package ru.forjb.wp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 60)
    private String author;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    @Size(min = 1, max = 128)
    @Pattern(regexp = "[A-Za-z0-9]{1,128}")
    private String callNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
}
