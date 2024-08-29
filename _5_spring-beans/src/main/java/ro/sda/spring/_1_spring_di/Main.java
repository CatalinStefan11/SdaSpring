package ro.sda.spring._1_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._1_spring_di.beans.Cat;
import ro.sda.spring._1_spring_di.components.Dog;
import ro.sda.spring._1_spring_di.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Cat c1 = ctx.getBean("cat", Cat.class);
            c1.sayMeow();

            Dog dog = ctx.getBean(Dog.class);
            dog.sayHam();
        }

    }
}
