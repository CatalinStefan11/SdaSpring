package ro.sda.spring.controller;

import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Person;

@RestController
public class HelloController {

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello world!";
    }

    // request parameter (query param) -> dns:port/endpoint?paramKey=paramValue
    @GetMapping("/hello")
    public String helloByName(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    // path parameter -> dns:port/endpoint/valueForPathParam
    @GetMapping("/hello/{n}")
    public String helloWithPathParam(@PathVariable("n") String name) {
        return "Hello " + name + " from the other side!";
    }

    // request header -> dns:port/endpoint + additional header in the headers section of the request
    @GetMapping("/goodbye")
    public String goodbye(@RequestHeader(name = "name-header", required = false) String name) {
        return "Goodbye, " + name + "!";
    }

    // request body -> dns:port/endpoint + additional body in JSON format
    @PostMapping("/solong")
    public String solong(@RequestBody Person jsonBody) {
        return "So long " + jsonBody.getName()+ "! You are now " + jsonBody.getAge() + " years old";
    }

}
