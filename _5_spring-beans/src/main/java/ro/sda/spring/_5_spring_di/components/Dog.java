package ro.sda.spring._5_spring_di.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Setter
@Getter
@Component
public class Dog {

    @Value("Rex")
    private String name;

    public Dog() {
        System.out.println("Dog constructor called!");
    }
}
