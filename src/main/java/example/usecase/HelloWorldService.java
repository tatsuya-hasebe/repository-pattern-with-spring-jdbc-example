package example.usecase;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String hello() {
        return "Hello, World!";
    }
}
