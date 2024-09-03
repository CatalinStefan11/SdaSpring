package ro.sda.spring.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.sda.spring.service.LearningService;

@Service
@Profile("hello")
public class HelloServiceImpl implements LearningService {
    @Override
    public String getHtmlFile() {
        return "hello.html";
    }
}
