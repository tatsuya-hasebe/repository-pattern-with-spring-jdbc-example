package example.usecase.todo;

import java.util.Optional;

import example.domain.todo.Todo;

public interface ChangeDescUseCase {
    Optional<Todo> execute(Long id, String desc);
}
