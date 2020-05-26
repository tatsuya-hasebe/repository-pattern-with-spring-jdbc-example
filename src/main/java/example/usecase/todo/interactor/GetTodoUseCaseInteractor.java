package example.usecase.todo.interactor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;
import example.usecase.todo.GetTodoUseCase;

@Service
public class GetTodoUseCaseInteractor implements GetTodoUseCase {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<Todo> execute(Long id) {
        return todoRepository.findById(id);
    }
}
