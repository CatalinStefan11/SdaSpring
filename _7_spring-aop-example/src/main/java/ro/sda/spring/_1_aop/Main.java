package ro.sda.spring._1_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring._1_aop.config.ProjectConfig;
import ro.sda.spring._1_aop.services.MathService;

public class Main {

    public static void main(String[] args) {

        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            MathService mathService = c.getBean(MathService.class);

            try {
                mathService.add(10, 2);
            } catch (RuntimeException ex) {
                // ignored
            }

            mathService.add(4, 5);
            mathService.subtract(11, 4);

            try {
                mathService.divide(12, 3);
            } catch (Exception ex) {
                // ignored
            }

        }

    }
}
