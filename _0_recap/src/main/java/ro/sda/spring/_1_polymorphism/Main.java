package ro.sda.spring._1_polymorphism;

public class Main {
    public static void main(String[] args) {

        Animal a = new Animal();
        Animal a2 = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();

        a.makeSound();
        d.makeSound();
        c.makeSound();
    }
}