package ro.sda.spring._3_spring_di.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Dog {
    private String name;

    public Dog() {
        System.out.println("Dog constructor was called");
    }
}
