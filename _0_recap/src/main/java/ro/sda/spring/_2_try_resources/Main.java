package ro.sda.spring._2_try_resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,67,8,8,9);
        stream.forEach(System.out::println);


        File n = new File("test.txt");

        PrintWriter p  = new PrintWriter(n);


        try(PrintWriter c = new PrintWriter(n)){

        }
    }

}
