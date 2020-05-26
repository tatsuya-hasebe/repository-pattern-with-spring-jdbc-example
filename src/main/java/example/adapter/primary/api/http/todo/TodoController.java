package example.adapter.primary.api.http.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import example.adapter.primary.api.http.todo.request.ChangeDescRequestModel;
import example.adapter.primary.api.http.todo.request.ChangeTitleRequestModel;
import example.adapter.primary.api.http.todo.request.NewTodoRequestModel;
import example.adapter.primary.api.http.todo.response.TodoResponseModel;
import example.adapter.primary.api.http.todo.response.TodoResponseModelMapper;
import example.domain.todo.Todo;
import example.domain.todo.TodoFilter;
import example.usecase.todo.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private GetTodoUseCase getTodoUseCase;

    @Autowired
    private ListTodosUseCase listTodosUseCase;

    @Autowired
    private NewTodoUseCase newTodoUseCase;

    @Autowired
    private ChangeTitleUseCase changeTitleUseCase;

    @Autowired
    private ChangeDescUseCase changeDescUseCase;

    @Autowired
    private ToggleTodoUseCase toggleTodoUseCase;

    @Autowired
    private DeleteTodoUseCase deleteTodoUseCase;

    @GetMapping("/{id}")
    public ResponseEntity getTodo(@PathVariable Long id) {
        return getTodoUseCase
                .execute(id)
                .map(todo -> ResponseEntity.ok().body(TodoResponseModelMapper.mapToTodoResponseModel(todo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity listTodos(@RequestParam(value = "filter", defaultValue = "all") String filter) {
        try {
            String pascalCaseFilter =
                    filter.substring(0, 1).toUpperCase() + filter.substring(1).toLowerCase();

            List<Todo> todos = listTodosUseCase.execute(TodoFilter.valueOf(pascalCaseFilter));

            return ResponseEntity.ok()
                    .body(todos.stream().map(TodoResponseModelMapper::mapToTodoResponseModel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(filter + " is not valid request parameter");
        }

    }

    @PostMapping
    public TodoResponseModel newTodo(@RequestBody NewTodoRequestModel req) {
        return TodoResponseModelMapper.mapToTodoResponseModel(
            newTodoUseCase.execute(req.getTitle(), req.getDesc())
        );
    }

    @PostMapping("/{id}/change-title")
    public ResponseEntity changeTitle(@PathVariable Long id, @RequestBody ChangeTitleRequestModel req) {
        return changeTitleUseCase.execute(id, req.getTitle())
                .map(todo -> ResponseEntity.ok().body(TodoResponseModelMapper.mapToTodoResponseModel(todo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/change-desc")
    public ResponseEntity changeDesc(@PathVariable Long id, @RequestBody ChangeDescRequestModel req) {
        return changeDescUseCase.execute(id, req.getDesc())
                .map(todo -> ResponseEntity.ok().body(TodoResponseModelMapper.mapToTodoResponseModel(todo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/toggle")
    public ResponseEntity toggleTodo(@PathVariable Long id) {
        return toggleTodoUseCase.execute(id)
                .map(todo -> ResponseEntity.ok().body(TodoResponseModelMapper.mapToTodoResponseModel(todo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) {
        return deleteTodoUseCase.execute(id)
                .map(todo -> ResponseEntity.noContent().build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
