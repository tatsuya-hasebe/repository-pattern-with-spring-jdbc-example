package example.usecase.todo;

import java.util.Optional;

import example.domain.todo.Todo;

public interface DeleteTodoUseCase {
    Optional<Todo> execute(Long id);
}
