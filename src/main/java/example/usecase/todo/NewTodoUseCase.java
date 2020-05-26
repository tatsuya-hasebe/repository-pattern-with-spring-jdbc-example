package example.usecase.todo;

import example.domain.todo.Todo;

public interface NewTodoUseCase {
    Todo execute(String title, String desc);
}
