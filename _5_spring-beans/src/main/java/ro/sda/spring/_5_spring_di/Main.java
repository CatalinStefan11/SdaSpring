package ro.sda.spring._5_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._5_spring_di.components.Dog;
import ro.sda.spring._5_spring_di.components.Owner;
import ro.sda.spring._5_spring_di.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = ctx.getBean(Owner.class);
            Dog d = o.getDog();

            System.out.println(d);

            Dog d2 = ctx.getBean(Dog.class);
            System.out.println(d2);
        }
    }
}
