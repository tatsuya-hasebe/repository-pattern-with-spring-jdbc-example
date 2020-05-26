package example.domain.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Optional<Todo> findById(Long id);

    List<Todo> findAll();

    List<Todo> filterBy(TodoFilter filter);

    Todo save(NewTodo todo);

    Todo save(Todo todo);

    void remove(Long id);
}
