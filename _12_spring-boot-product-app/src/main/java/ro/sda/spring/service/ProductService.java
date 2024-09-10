package ro.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sda.spring.exception.ValidationFailedException;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        log.info("ProductService constructor called!");
    }

    public void addProduct(Product p) {
        log.info("Adding a new product to the database");
        if (p != null && !p.getName().isBlank() && p.getPrice() > 0) {
            productRepository.addProduct(p.getName(), p.getDescription(), p.getPrice(), p.isInStock());
        } else {
            throw new ValidationFailedException("Product is null or either the name is empty or price is less than 0.");
        }
    }

    public List<Product> getAllProducts() {
        log.info("Querying the DB for all the existent products");
        return productRepository.getAllProducts();
    }

    public Product findById(int id) {
        log.info("Querying for product with id {}", id);
        return productRepository.findById(id);
    }

    public void deleteById(int id) {
        log.info("Deleting product with id {}", id);
        productRepository.deleteById(id);
    }

    public void updateById(int id, Product p){
        log.info("Updating product with id {}", id);
        productRepository.updateById(id, p.getName(), p.getDescription(), p.getPrice(), p.isInStock());
    }
}
