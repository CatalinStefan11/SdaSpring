package ro.sda.spring.services.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.NameService;

@Service(value = "simple")
@Primary
public class SimpleNameService implements NameService {
    @Override
    public String getName() {
        return "Catalin";
    }
}
