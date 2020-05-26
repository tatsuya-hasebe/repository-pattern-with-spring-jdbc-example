package example.usecase.todo.interactor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;
import example.usecase.todo.ChangeTitleUseCase;

@Service
public class ChangeTitleUseCaseInteractor implements ChangeTitleUseCase {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<Todo> execute(Long id, String title) {
        Optional<Todo> maybeTodo = todoRepository.findById(id);

        return maybeTodo.map(todo -> {
            Todo changedTodo = todo.changeTitle(title);

            return todoRepository.save(changedTodo);
        });
    }
}
