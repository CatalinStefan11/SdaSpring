package ro.sda.spring._5_spring_di.components;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Owner {
    @Value("Adi")
    private String name;
    private Dog dog;


    // constructor dependency injection - @Autowired is not necessary anymore
//    @Autowired
    public Owner(Dog dog) {
        this.dog = dog;
        System.out.println("Owner constructor called!");
    }
}
