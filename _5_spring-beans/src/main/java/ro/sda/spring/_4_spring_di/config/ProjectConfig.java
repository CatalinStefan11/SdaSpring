package ro.sda.spring._4_spring_di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.spring._4_spring_di.beans.Dog;
import ro.sda.spring._4_spring_di.beans.Owner;

@Configuration
public class ProjectConfig {

    public ProjectConfig() {
        System.out.println("ProjectConfig constructor called!");
    }

    @Bean
    public Owner owner() {
        Owner o = new Owner();
        o.setName("John");
        return o;
    }

    @Bean
    public Dog dog() {
        Dog d = new Dog();
        d.setName("Pit");
        return d;
    }

}
