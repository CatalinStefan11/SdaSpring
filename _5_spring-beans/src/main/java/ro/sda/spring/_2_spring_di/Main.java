package ro.sda.spring._2_spring_di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._2_spring_di.beans.Dog;
import ro.sda.spring._2_spring_di.beans.Owner;
import ro.sda.spring._2_spring_di.cofig.ProjectConfig;

public class Main {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            Owner o = ctx.getBean(Owner.class);

            System.out.println(o.getName());
            System.out.println(o);

            Dog d =  ctx.getBean(Dog.class);

            System.out.println(d.getName());
            System.out.println(d);

            System.out.println("---------------------------");

            Dog d2 = ctx.getBean(Dog.class);
            System.out.println(d2);


        }
    }
}
