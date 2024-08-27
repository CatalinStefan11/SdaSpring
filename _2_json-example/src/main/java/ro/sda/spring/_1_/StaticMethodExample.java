package ro.sda.spring._1_;

public class StaticMethodExample {


    public static void main(String[] args) {

        Example e1 = new Example();
        e1.instanceMethod();

        Example.staticMethod();
    }

}

class Example {
    void instanceMethod() {
        System.out.println("I'm an instance method");
    }

    static void staticMethod() {
        System.out.println("I'm a static method");
    }
}
