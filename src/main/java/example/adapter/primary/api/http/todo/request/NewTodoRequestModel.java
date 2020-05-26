package example.adapter.primary.api.http.todo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewTodoRequestModel {
    private String title;
    private String desc;
}
