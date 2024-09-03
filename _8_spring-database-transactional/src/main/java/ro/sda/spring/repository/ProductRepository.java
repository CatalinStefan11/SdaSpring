package ro.sda.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.spring.mapper.ProductRowMapper;
import ro.sda.spring.model.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class ProductRepository {

    // autowired on an attribute means field dependency injection, and it's not the best practice
    // because if we want to test this repo we need to use reflection to inject a mock of jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, name varchar(255))";
        jdbcTemplate.update(sql);
    }

    @PreDestroy
    void dropDatabase() {
        String sql = "DROP TABLE product";
        jdbcTemplate.update(sql);
    }

    public void addProduct(String name) {
        String sql = "INSERT INTO product(name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public void addProductsWithoutTransaction(String nameP1, String nameP2) {
        String sql = "INSERT INTO product(name) VALUES (?)";
        jdbcTemplate.update(sql, nameP1);
        if (nameP2.contains("iphone")) {
            throw new RuntimeException("Exception during the addition of the second product to DB");
        }
        jdbcTemplate.update(sql, nameP2);
    }

    @Transactional
    public void addProductsWithTx(String nameP1, String nameP2) {
        String sql = "INSERT INTO product(name) VALUES (?)";
        jdbcTemplate.update(sql, nameP1);
        if (nameP2.contains("headset")) {
            throw new RuntimeException("Exception during the addition of the second product to DB");
        }
        jdbcTemplate.update(sql, nameP2);
    }
}


/*
@Repository -> database layer (we do queries on the database)
@Service -> business logic layer
@Controller -> web layer
 */