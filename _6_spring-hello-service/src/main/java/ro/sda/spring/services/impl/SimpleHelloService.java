package ro.sda.spring.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.HelloService;
import ro.sda.spring.services.NameService;

@Service
public class SimpleHelloService implements HelloService {

//    @Qualifier("random")
//    @Autowired
    private NameService nameService;

    public SimpleHelloService(@Qualifier("random") NameService nameService) {
        this.nameService = nameService;
    }

    @Override
    public void sayHello() {
        String name = nameService.getName();
        System.out.println("Hello, " + name + "!");
    }
}
