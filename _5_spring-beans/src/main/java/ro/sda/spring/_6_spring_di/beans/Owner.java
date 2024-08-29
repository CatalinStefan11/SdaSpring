package ro.sda.spring._6_spring_di.beans;

import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
public class Owner {
    public Cat cat;

    public Owner(Cat cat) {
        this.cat = cat;
        System.out.println("Owner constructor called!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Owner was created");
    }


    @PreDestroy
    public void destroy() {
        System.out.println("Owner is destroying");
    }
}

