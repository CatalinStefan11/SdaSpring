package ro.sda.spring._1_spring_di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ro.sda.spring._1_spring_di.beans.Cat;

@Configuration
@ComponentScan("ro.sda.spring._1_spring_di.components")
public class ProjectConfig {

    public ProjectConfig() {
        System.out.println("ProjectConfig constructor called!");
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
