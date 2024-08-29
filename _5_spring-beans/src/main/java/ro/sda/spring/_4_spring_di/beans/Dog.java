package ro.sda.spring._4_spring_di.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dog {

    private String name;

    public Dog() {
        System.out.println("Dog constructor called!");
    }
}
