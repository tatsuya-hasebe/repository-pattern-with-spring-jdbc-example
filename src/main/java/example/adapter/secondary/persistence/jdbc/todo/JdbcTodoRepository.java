package example.adapter.secondary.persistence.jdbc.todo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;

@Repository
public class JdbcTodoRepository implements TodoRepository {
    @Override
    public List<Todo> findAll() {
        return Arrays.asList(
            Todo
              .builder()
              .id(1L)
              .title("Hello, Spring Boot!")
              .desc("Get Started With Spring Boot")
              .done(false)
              .build(),
            Todo
              .builder()
              .id(2L)
              .title("Hello, Spring JDBC!")
              .desc("Get Started With Spring JDBC")
              .done(false)
              .build()
        );
    }
}
