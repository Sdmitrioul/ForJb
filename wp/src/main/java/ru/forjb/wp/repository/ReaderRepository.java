package ru.forjb.wp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.forjb.wp.domain.Reader;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    List<Reader> findAllByOrderByCreationTimeDesc();
    Reader findReaderById(Long id);
    List<Reader> findReaderByNameAndAndSurname(String name, String surname);
}
