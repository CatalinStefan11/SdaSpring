package ro.sda.spring._2_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String color;
    private int horsePower;
    private boolean isManual;
}
