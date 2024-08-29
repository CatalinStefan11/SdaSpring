package ro.sda.spring._1_aop.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public int add(int a, int b) {
        if ((a + b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a + b;
    }

    public int subtract(int a, int b) {
        if ((a - b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a - b;
    }

    public int multiply(int a, int b) {
        if ((a * b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a * b;
    }

    public int divide(int a, int b) {
        if ((a / b) % 2 == 0) {
            throw new RuntimeException("Exception occurred");
        }
        return a / b;
    }
}


/*
     7 % 2 = 1
     6 % 2 = 0

     9 % 2 = 1
     9 % 3 = 0
     11 % 3 = 2
 */