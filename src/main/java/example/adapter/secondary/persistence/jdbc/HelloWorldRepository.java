package example.adapter.secondary.persistence.jdbc;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepository {
    public String hello() {
        return "Hello, World!";
    }
}
