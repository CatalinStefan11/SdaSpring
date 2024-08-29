package ro.sda.spring._6_spring_di.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cat {

    public Cat() {
        System.out.println("Cat constructor called!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Cat was created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Cat is destroying");
    }

    public void seyMeow() {
        System.out.println("Meow");
    }
}
