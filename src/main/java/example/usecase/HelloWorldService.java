package example.usecase;

import example.adapter.secondary.persistence.jdbc.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    @Autowired
    private HelloWorldRepository helloWorldRepository;

    public String hello() {
        return helloWorldRepository.hello();
    }
}
