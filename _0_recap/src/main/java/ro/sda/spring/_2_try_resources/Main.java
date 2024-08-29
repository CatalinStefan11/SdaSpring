package ro.sda.spring._2_try_resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            System.out.println(scanner.next());
        } finally {
//            if( scanner != null) {
//                System.out.println("Scanner is closing");
//                scanner.close();
//            }
        }
        System.out.println("Program is finishing");

        // try-with-resources
        try(Scanner s1 = new Scanner(System.in)) {
            System.out.println(s1.next());
        }

    }

}
