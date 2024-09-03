package ro.sda.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.sda.spring.service.LearningService;

@Service
@Slf4j
@Profile("learning")
public class LearningServiceImpl implements LearningService {
    @Override
    public String getHtmlFile() {
        log.error("This is just for learning purpose");
        return "learning.html";
    }
}
