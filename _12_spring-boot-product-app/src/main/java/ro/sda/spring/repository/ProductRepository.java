package ro.sda.spring.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ro.sda.spring.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        log.info("ProductRepository constructor called!");
    }

    @PostConstruct
    public void init() {
        String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, " +
                "name varchar(255), description varchar(255), price DOUBLE, in_stock BOOLEAN)";
        jdbcTemplate.update(sql);
        log.info("Database initialized and table product created!");
    }

    @PreDestroy
    void dropDatabase() {
        String sql = "DROP TABLE product";
        jdbcTemplate.update(sql);
    }

    public void addProduct(String name, String description, double price, boolean inStock) {
        String sql = "INSERT INTO product(name, description, price, in_stock) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, description, price, inStock);
        log.info("Product with name {} added to the database", name);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        List<Product> productList = jdbcTemplate.query(sql, new ProductMapper());
        log.info("Retrieved {} products from database.", productList.size());
        return productList;
    }

    public Product findById(int id) {
        String sql = "SELECT * FROM product WHERE ID = ?";

        // the functional way
        List<Product> productList = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"),
                rs.getString("description"), rs.getDouble("price"), rs.getBoolean("in_stock")),
                id);

        if (!productList.isEmpty()) {
            Product p = productList.getFirst();
            log.info("Product with name {} found in the database as a match for id {}", p.getName(), p.getId());
            return p;
        }
        return null;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM product WHERE ID = ?";
        jdbcTemplate.update(sql, id);
        log.info("Product with id {} deleted", id);
    }

    static class ProductMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            log.info("Mapping from ResultSet to an instance of Product class the row" +
                    " with number {} for product with name {}", rowNum, rs.getString("name"));
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));
            p.setInStock(rs.getBoolean("in_stock"));
            return p;
        }
    }
}
