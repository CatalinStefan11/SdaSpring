package ro.sda.spring._1_polymorphism;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow meow");
    }
}
