package ro.sda.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* This class is annotated with @SpringBootApplication and this means:
- spring will search the root package and ALL the subpackages of this class
(in this case ro.sda.spring + subpackages ro.sda.spring.config, ro.sda.spring.services etc)
for classes annotated with stereotype annotations (@Component, @Repository, @Service, @Controller)
as well as @Configuration, @RestController
 */
@SpringBootApplication
public class SpringProductApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringProductApp.class, args);
    }
}