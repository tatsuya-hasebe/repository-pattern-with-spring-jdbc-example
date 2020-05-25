package example.adapter.secondary.persistence.jdbc;

import example.domain.HelloWorldRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcHelloWorldRepository implements HelloWorldRepository {
    @Override
    public String hello() {
        return "Hello, World!";
    }
}
