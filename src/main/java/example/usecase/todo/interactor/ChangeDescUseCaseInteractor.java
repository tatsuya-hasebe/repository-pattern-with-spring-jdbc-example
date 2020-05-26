package example.usecase.todo.interactor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;
import example.usecase.todo.ChangeDescUseCase;

@Service
public class ChangeDescUseCaseInteractor implements ChangeDescUseCase {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<Todo> execute(Long id, String desc) {
        Optional<Todo> maybeTodo = todoRepository.findById(id);

        return maybeTodo.map(todo -> {
            Todo changedTodo = todo.changeDesc(desc);

            return todoRepository.save(changedTodo);
        });
    }
}
