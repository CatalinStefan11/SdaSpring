package ro.sda.spring.service;

import jakarta.annotation.Nullable;
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

    public List<Book> getBooksByPriceGraterOrEqualAndGenderContains(int price, @Nullable String gender) {
        log.debug("Querying for books with price greater or equal with {} and gender contains {}", price, gender);

        List<Book> books;

        if (gender != null && price > 0) {
            books = bookRepository.findByPriceGreaterThanEqualAndGenderContains(price, gender);
        } else if (price > 0) {
            books = bookRepository.findByPriceGreaterThanEqual(price);
        } else {
            books = bookRepository.findByGenderContains(gender);
        }

        log.debug("{} books found with price greater or equal than {} and with gender containing {}", books.size(), price, gender);
        return books;
    }

    public void deleteById(int id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with id " + id + " was not found! Nothing to delete!");
        }
        log.debug("Deleting book with id {}", id);
        bookRepository.deleteById(id);
        log.debug("Book with id {} deleted", id);
    }

    public void updateById(int id, Book toUpdate) {
        if(!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with id " + id + " was not found! Nothing to update!");
        }
        log.debug("Updating book with id {}", id);
        toUpdate.setId(id);
        bookRepository.save(toUpdate);
        log.debug("Book with id {} updated", id);
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
