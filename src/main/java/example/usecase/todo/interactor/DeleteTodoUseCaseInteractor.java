package example.usecase.todo.interactor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;
import example.usecase.todo.DeleteTodoUseCase;

@Service
public class DeleteTodoUseCaseInteractor implements DeleteTodoUseCase {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<Todo> execute(Long id) {
        Optional<Todo> maybeTodo = todoRepository.findById(id);

        maybeTodo.ifPresent(todo -> todoRepository.remove(todo.getId()));

        return maybeTodo;
    }
}
