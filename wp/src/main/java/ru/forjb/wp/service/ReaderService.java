package ru.forjb.wp.service;

import org.springframework.stereotype.Service;
import ru.forjb.wp.domain.Reader;
import ru.forjb.wp.repository.ReaderRepository;
import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository repository;

    public ReaderService(ReaderRepository repository) {
        this.repository = repository;
    }

    public List<Reader> getAllReaders() {
        return repository.findAllByOrderByCreationTimeDesc();
    }

    public Reader findByReaderId(Long id) {
        return repository.findReaderById(id);
    }

    public void addReader(Reader readerForm) {
        repository.save(readerForm);
    }

    public List<Reader> findByReaderNameAndSurname(Reader readerForm) {
        return repository.findReaderByNameAndAndSurname(readerForm.getName(), readerForm.getSurname());
    }
}
