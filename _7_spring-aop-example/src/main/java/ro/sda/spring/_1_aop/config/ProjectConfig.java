package ro.sda.spring._1_aop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ro.sda.spring._1_aop.aspects.MathServiceAspect;

@Configuration
@ComponentScan("ro.sda.spring._1_aop.services")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public MathServiceAspect aspect() {
        return new MathServiceAspect();
    }

}
