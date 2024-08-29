package ro.sda.spring._3_spring_di.components;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Owner {

    private String name;
    private Dog dog;

    public Owner() {
        System.out.println("Owner constructor was called");
    }

    public void setName(String name) {
        this.name = name;
    }

    // setter dependency injection
    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
