package ro.sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.spring.model.Book;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByGenderContains(String gender);
    List<Book> findByPriceGreaterThanEqual(int price);
    List<Book> findByPriceGreaterThanEqualAndGenderContains(int price, String gender);

}
