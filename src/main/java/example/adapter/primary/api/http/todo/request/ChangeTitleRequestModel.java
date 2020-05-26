package example.adapter.primary.api.http.todo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeTitleRequestModel {
    private String title;
}
