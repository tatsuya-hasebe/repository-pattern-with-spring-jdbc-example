package example.domain.todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();
}
