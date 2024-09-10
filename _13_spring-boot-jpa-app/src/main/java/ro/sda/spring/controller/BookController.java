package ro.sda.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Book;
import ro.sda.spring.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // -> example:  http://localhost:8081/book/add (+ body of book)
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    // example: http://localhost:8081/book/all
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // example: http://localhost:8081/book/1
    @GetMapping("/{idFromReq}")
    public Book getById(@PathVariable("idFromReq") int id) {
        return bookService.findById(id);
    }
}
