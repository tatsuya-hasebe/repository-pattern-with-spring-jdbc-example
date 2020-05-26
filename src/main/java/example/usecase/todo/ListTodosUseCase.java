package example.usecase.todo;

import java.util.List;

import example.domain.todo.Todo;
import example.domain.todo.TodoFilter;

public interface ListTodosUseCase {
    List<Todo> execute(TodoFilter filter);
}
