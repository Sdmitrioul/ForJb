package ru.forjb.wp.service;

import org.springframework.stereotype.Service;
import ru.forjb.wp.domain.Book;
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.form.BookCredentials;
import ru.forjb.wp.repository.BookRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        Comparator<Book> bookComparator = Comparator.comparing(Book::getTitle);
        Collections.sort(books, bookComparator);
        return books;
    }

    public Book findByBookId(long bookId) {
        return bookRepository.findBookById(bookId);
    }

    public boolean isCallNumberVacant(String callNumber) {
        return bookRepository.countByCallNumber(callNumber) == 0;
    }

    public void saveEditing(BookCredentials book) {
        Book in = bookRepository.findBookById(book.getId());
        in.setCallNumber(book.getCallNumber());
        bookRepository.save(in);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public void addBook(Book bookForm) {
        bookRepository.save(bookForm);
    }

    public Book findByBookCallNumber(String callNumber) {
        return bookRepository.findBookByCallNumber(callNumber);
    }
}
