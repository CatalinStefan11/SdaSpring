package ro.sda.spring._3_optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        retrieveWithoutOptional();
        retrieveWithOptional();
    }

    public static void retrieveWithoutOptional() {
        Book b1 = getBookById(1);
        System.out.println("Book with id " + b1.getId() + " and title " + b1.getTitle() + " retrieved!");

        Book b2 = getBookById(3);
        System.out.println("Book with id " + b2.getId() + " and title " + b2.getTitle() + " retrieved!");
    }

    public static Book getBookById(int id) {
        if (id == 1) {
            return new Book(1, "Harap Alb", 20);
        } else {
            return null;
        }
    }

    public static void retrieveWithOptional() {
        Optional<Book> bookOptional = gotBookByIdWithOptional(1);
        printIfPresent(bookOptional);

        Optional<Book> bookOptional2 = gotBookByIdWithOptional(12);
        printIfPresent(bookOptional2);
    }

    public static void printIfPresent(Optional<Book> bookOptional) {
        if(bookOptional.isPresent()){
            Book fromOptional = bookOptional.get();
            System.out.println("Book with id " + fromOptional.getId() + " and title " + fromOptional.getTitle() + " retrieved!");
        } else {
            System.out.println("Nothing inside optional");
        }
    }

    public static Optional<Book> gotBookByIdWithOptional(int id) {
        if (id == 1) {
            return Optional.of(new Book(1, "Harap Alb", 20));
        } else {
            return Optional.empty();
        }
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Book {
        private int id;
        private String title;
        private int price;
    }
}
