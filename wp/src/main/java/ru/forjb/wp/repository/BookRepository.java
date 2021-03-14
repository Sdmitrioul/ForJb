package ru.forjb.wp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.forjb.wp.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    Book findBookById(Long id);
    Book findBookByCallNumber(String callNumber);
    int countByCallNumber(String callNumber);
}
