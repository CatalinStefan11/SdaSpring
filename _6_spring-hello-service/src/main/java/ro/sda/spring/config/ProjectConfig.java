package ro.sda.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ro.sda.spring.services.impl")
public class ProjectConfig {

}

/*
@ComponentScan is telling Spring to look for classes annotated with stereotype annotations in the target packages

Stereotype annotations are:
- @Controller
- @Service
- @Repository
- @Component
 */
