package ro.sda.spring;

public class Main {

    public static void main(String[] args) {

        User u1 = new User("Catalin", "Manaila", 26);

        System.out.println(u1.getFirstName());
        System.out.println(u1.getLastName());
        System.out.println(u1.getAge());

    }
}
