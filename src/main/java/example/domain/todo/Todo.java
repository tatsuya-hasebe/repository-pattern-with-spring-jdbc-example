package example.domain.todo;

import lombok.*;

@Data
@Builder
public class Todo {
    private Long id;
    private String title;
    private String desc;
    private Boolean done;
}
