package example.usecase.todo;

import java.util.Optional;

import example.domain.todo.Todo;

public interface ChangeTitleUseCase {
    Optional<Todo> execute(Long id, String title);
}
