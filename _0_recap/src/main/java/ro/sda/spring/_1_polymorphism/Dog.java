package ro.sda.spring._1_polymorphism;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The DOG makes a sound");
    }
}
