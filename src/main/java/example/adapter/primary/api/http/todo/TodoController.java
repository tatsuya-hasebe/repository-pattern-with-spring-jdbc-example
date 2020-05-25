package example.adapter.primary.api.http.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.domain.todo.Todo;
import example.usecase.todo.ListTodosUseCase;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private ListTodosUseCase listTodosUseCase;

    @GetMapping
    public List<Todo> listTodos() {
        return listTodosUseCase.execute();
    }
}
