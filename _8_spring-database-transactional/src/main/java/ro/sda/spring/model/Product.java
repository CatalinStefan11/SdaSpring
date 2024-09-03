package ro.sda.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;

    public Product(String name) {
        this.name = name;
    }
}
