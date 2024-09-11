package ro.sda.spring.controller;

import jakarta.validation.Valid;
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
    public void addBook(@RequestBody @Valid Book book) {
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


    // example: http://localhost:8081/book?price=10&gender=Fairy
    // example: http://localhost:8081/book?price=20
    // if we don't provide the values for the request params (query params) we will get the default value
    // for those types (primitive type int = 0, reference type string = null)
    @GetMapping
    public List<Book> getByPriceEqualOrGreater(@RequestParam(value = "price", required = false, defaultValue = "0") int price,
                                               @RequestParam(value = "gender", required = false) String gender) {
        return bookService.getBooksByPriceGraterOrEqualAndGenderContains(price, gender);
    }

    // example: http://localhost:8081/book/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") int id) {
        bookService.deleteById(id);
    }

    // example: http://localhost:8081/book/1 (+ body of the book that would overwrite an existent entry in DB)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateById(@PathVariable("id") int id, @RequestBody Book toUpdate) {
        bookService.updateById(id, toUpdate);
    }
}
