package ro.sda.spring._2_spring_di.beans;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Owner {
    private String name;
    // class composition
    private Dog dog;

    public Owner() {
        System.out.println("Owner constructor called!");
    }
}
