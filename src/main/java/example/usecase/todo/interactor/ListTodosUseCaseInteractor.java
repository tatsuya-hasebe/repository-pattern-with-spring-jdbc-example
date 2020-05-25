package example.usecase.todo.interactor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;
import example.usecase.todo.ListTodosUseCase;


@Service
public class ListTodosUseCaseInteractor implements ListTodosUseCase {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> execute() {
        return todoRepository.findAll();
    }
}
