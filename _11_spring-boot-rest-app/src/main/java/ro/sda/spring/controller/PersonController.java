package ro.sda.spring.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Person;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public Person getPerson(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);

        Person p = new Person();
        p.setAge(23);
        p.setName("Alex");
        return p;
    }

    @GetMapping("/get-entity")
    public ResponseEntity<Person> getPersonEntity() {
        Person p = new Person("Catalin", 26);
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }
}
