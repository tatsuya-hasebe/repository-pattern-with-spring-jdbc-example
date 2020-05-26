package example.usecase.todo.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.todo.NewTodo;
import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;
import example.usecase.todo.NewTodoUseCase;

@Service
public class NewTodoUseCaseInteractor implements NewTodoUseCase {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo execute(String title, String desc) {
        NewTodo newTodo =
                NewTodo.builder()
                    .title(title)
                    .desc(desc)
                    .completed(false)
                    .build();

        return todoRepository.save(newTodo);
    }
}
