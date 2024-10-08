package ro.sda.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello.html";
    }

    @GetMapping("/world")
    public String helloWorld() {
        return "hello-world.html";
    }

}
