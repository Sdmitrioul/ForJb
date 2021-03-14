package ru.forjb.wp.form;

import ru.forjb.wp.domain.Book;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BookCredentials {
    private long id;

    private String title;

    private String author;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @NotNull
    @NotEmpty
    @Column(unique = true)
    @Size(min = 1, max = 128)
    @Pattern(regexp = "[A-Za-z0-9]{1,128}")
    private String callNumber;

    public BookCredentials(Book book) {
        id = book.getId();
        title = book.getTitle();
        author = book.getAuthor();
        callNumber = book.getCallNumber();
    }

    public BookCredentials() {
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getId() {
        return id;
    }
}
