package ro.sda.spring._4_spring_di.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
public class Owner {

    private String name;

    // field dependency injection
    @Autowired
    private Dog dog;

    public Owner() {
        System.out.println("Owner constructor called!");
    }
}
