package ro.sda.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Product;
import ro.sda.spring.service.ProductService;

import java.util.List;

@Slf4j
@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
        log.info("ProductController constructor called!");
    }

    @PostMapping("/product/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product p) {
        productService.addProduct(p);
    }

    @GetMapping("/product/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Product p = productService.findById(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return new ResponseEntity<>(null,null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") int id) {
        productService.deleteById(id);
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void putById(@PathVariable("id") int id, @RequestBody Product body) {
        productService.updateById(id, body);
    }


}
