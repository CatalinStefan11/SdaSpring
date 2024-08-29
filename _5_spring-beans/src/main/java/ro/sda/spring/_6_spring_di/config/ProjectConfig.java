package ro.sda.spring._6_spring_di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ro.sda.spring._6_spring_di.beans.Cat;
import ro.sda.spring._6_spring_di.beans.Owner;

@Configuration
public class ProjectConfig {

    @Bean
    @Scope(value = "prototype")
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public Owner owner() {
        return new Owner(cat());
    }
}
