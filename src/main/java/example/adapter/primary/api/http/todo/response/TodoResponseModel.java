package example.adapter.primary.api.http.todo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseModel {
    private Long id;
    private String title;
    private String desc;
    private Boolean completed;
}
