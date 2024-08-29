package ro.sda.spring._3_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._3_spring_di.components.Dog;
import ro.sda.spring._3_spring_di.components.Owner;
import ro.sda.spring._3_spring_di.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = ctx.getBean(Owner.class);
            System.out.println(o.getName());
            System.out.println(o.getDog());

            System.out.println("---------------------------");

            Dog d =  ctx.getBean(Dog.class);

            System.out.println(d.getName());
            System.out.println(d);

        }
    }
}
