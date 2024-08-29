package ro.sda.spring._2_spring_di.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {
    private String name;

    public Dog() {
        System.out.println("Dog constructor called!");
    }
}
