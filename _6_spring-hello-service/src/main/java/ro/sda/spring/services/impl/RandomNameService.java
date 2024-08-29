package ro.sda.spring.services.impl;

import org.springframework.stereotype.Service;
import ro.sda.spring.services.NameService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service(value = "random")
public class RandomNameService implements NameService {

    @Override
    public String getName() {
        List<String> names = Arrays.asList("Messi", "Ronaldo", "Neymar", "Mbappe");
        Random r = new Random();
        int i  = r.nextInt(4);
        return names.get(i);
    }
}
