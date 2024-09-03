package ro.sda.spring.service;

import org.springframework.stereotype.Service;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product p) {
        if (p != null && p.getName() != null) {
            if (p.getName().isBlank()) {
                p.setName("default");
            }
            productRepository.addProduct(p.getName());
            return;
        }
        throw new RuntimeException("Product/product name is null");
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addProductsWithoutTx(Product p1, Product p2) {
        productRepository.addProductsWithoutTransaction(p1.getName(), p2.getName());
    }

    public void addProductsWithTransactional(Product p1, Product p2) {
        productRepository.addProductsWithTx(p1.getName(), p2.getName());
    }
}
