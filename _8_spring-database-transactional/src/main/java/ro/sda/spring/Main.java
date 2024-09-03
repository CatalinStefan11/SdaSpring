package ro.sda.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.config.ProjectConfig;
import ro.sda.spring.model.Product;
import ro.sda.spring.service.ProductService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            ProductService productService = ctx.getBean(ProductService.class);

            productService.addProduct(new Product("macbook"));
            productService.addProduct(new Product("samsung tv"));
            productService.addProduct(new Product("nokia lumnia"));

            try {
                productService.addProduct(null);
            } catch (Exception ignored) {}

            try {
                productService.addProduct(new Product());
            } catch (Exception ignored) {}

            productService.addProduct(new Product(""));

            List<Product> productList = productService.getAllProducts();

//            for(Product p : productList) {
//                System.out.println(p);
//            }
            productList.forEach((Product p) -> System.out.println(p));


            System.out.println("----------------------------------");

            try {
                productService.addProductsWithoutTx(new Product("wallet"),  new Product("iphone"));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


            productList = productService.getAllProducts();

            productList.forEach((Product p) -> System.out.println(p));

            System.out.println("----------------------------------");


            try {
                productService.addProductsWithTransactional(new Product("phone"), new Product("headset"));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            productList = productService.getAllProducts();

            productList.forEach((Product p) -> System.out.println(p));
        }
    }
}