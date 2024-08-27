package ro.sda.spring._2_;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car("renault", "yellow", 100, true);

        try {
            System.out.println(mapper.writeValueAsString(car));
        } catch (JsonProcessingException e) {
            System.err.println("Exception with message: " + e.getMessage());
        }


        List<Car> carList = List.of(new Car("renault", "yellow", 100, true), new Car("honda", "civic", 200, true));

        try {
            System.out.println(mapper.writeValueAsString(carList));
        } catch (JsonProcessingException e) {
            System.err.println("Exception with message: " + e.getMessage());
        }
    }
}
