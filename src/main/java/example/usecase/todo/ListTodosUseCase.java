package example.usecase.todo;

import java.util.List;

import example.domain.todo.Todo;

public interface ListTodosUseCase {
    List<Todo> execute();
}
