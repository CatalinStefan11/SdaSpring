package ro.sda.spring._3_spring_di.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ro.sda.spring._3_spring_di.components")
public class ProjectConfig {

    public ProjectConfig() {
        System.out.println("ProjectConfig constructor called!");
    }
}
