package example.adapter.primary.api.http.todo.response;

import example.domain.todo.Todo;

public class TodoResponseModelMapper {
    private TodoResponseModelMapper() {}

    public static TodoResponseModel mapToTodoResponseModel(Todo todo) {
        return TodoResponseModel
                .builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .desc(todo.getDesc())
                .completed(todo.getCompleted())
                .build();
    }
}
