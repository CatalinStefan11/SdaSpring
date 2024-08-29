package ro.sda.spring._6_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._6_spring_di.beans.Cat;
import ro.sda.spring._6_spring_di.beans.Owner;
import ro.sda.spring._6_spring_di.config.ProjectConfig;

public class Main {

    public static void main(String[] args) {


        try(var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            System.out.println("Context is fully initialized");

            Owner o = ctx.getBean(Owner.class);
            System.out.println(o);

            Cat c1 = o.getCat();
            System.out.println(c1);

            Cat c2 = ctx.getBean(Cat.class);
            System.out.println(c2);

            Cat c3 = ctx.getBean(Cat.class);
            System.out.println(c3);

            c1.seyMeow();
            c2.seyMeow();
            c3.seyMeow();

            System.out.println("Context will be shut down");
        }

        System.out.println("Spring IoC container was shut down");
    }
}
