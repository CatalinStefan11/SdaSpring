package ro.sda.spring.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.sda.spring.exception.BookNotFoundException;
import ro.sda.spring.model.Book;
import ro.sda.spring.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


// this is a class containing unit tests
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    // A mock is an object that mimics the behaviour of a real object (component) in controlled ways.
    // It is mainly used in unit tests to isolate the system under test from its dependencies.
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;


    @Test
    void testAddBook() {
        Book b = new Book(1, "title1", "author-test", 100, "fairy-tale");

        bookService.addBook(b);

        verify(bookRepository, times(1)).save(b);
    }


    @Test
    void testGetAllBooks() {
        Book b1 = new Book(1, "title1", "author-test", 100, "fairy-tale");
        Book b2 = new Book(2, "title2", "author-test-2", 200, "roman");

        // given
        given(bookRepository.findAll()).willReturn(Arrays.asList(b1, b2));

        // when
        List<Book> bookList =  bookService.getAllBooks();

        // then
        assertEquals(2 ,bookList.size());
        assertEquals("title1", bookList.get(0).getTitle());
        assertEquals("title2", bookList.get(1).getTitle());

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Book b = new Book(100, "title1", "author-test", 100, "fairy-tale");

        given(bookRepository.findById(any())).willReturn(Optional.of(b));

        Book actual = bookService.findById(100);

        assertEquals("title1", actual.getTitle());
        assertEquals(100, actual.getId());
        verify(bookRepository, times(1)).findById(100);
    }


    @Test
    void testFindByIdNotFound() {
        given(bookRepository.findById(any())).willReturn(Optional.empty());

        Exception ex = assertThrows(BookNotFoundException.class, () -> {
            bookService.findById(1);
        });

        assertEquals("Book with id 1 not found in the database!", ex.getMessage());
    }
}
