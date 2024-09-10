package ro.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sda.spring.exception.BookNotFoundException;
import ro.sda.spring.model.Book;
import ro.sda.spring.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        log.debug("Adding book {} to database...", book);
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        log.debug("Retrieving all the books from database...");
        List<Book> retrieved = bookRepository.findAll();
        log.debug("Retrieved a list of {} books...", retrieved.size());
        return retrieved;
    }

    public Book findById(int id) {
        log.debug("Retrieving book with id {}", id);
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            log.debug("Found book with id {}", id);
            return bookOptional.get();
        }
        log.debug("Book with id {} was not found in the database", id);
        throw new BookNotFoundException("Book with id " + id + " not found in the database!");
    }
}


/*
    Log levels:

    -> fatal
    -> error
    -> warn
    -> info
    -> debug

    Log level is INFO we can see the following logs: INFO, WARN, ERROR, FATAL
    Log level is WARN we can see the following logs: WARN, ERROR, FATAL
    Log level is DEBUG we can see the following logs: DEBUG, INFO, WARN, ERROR, FATAL
 */
