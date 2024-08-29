package ro.sda.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.config.ProjectConfig;
import ro.sda.spring.services.HelloService;
import ro.sda.spring.services.NameService;

public class Main {

    public static void main(String[] args) {

        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            HelloService s = c.getBean(HelloService.class);
            s.sayHello();

            System.out.println("-----------------------");

            NameService nameService = c.getBean(NameService.class);
            System.out.println(nameService.getName());

        }
    }
}