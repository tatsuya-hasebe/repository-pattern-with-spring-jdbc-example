package example.adapter.secondary.persistence.jdbc.todo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import example.domain.todo.Todo;
import example.domain.todo.TodoRepository;

@Repository
public class JdbcTodoRepository implements TodoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Todo> findAll() {
        return jdbcTemplate.query("select * from todo", new BeanPropertyRowMapper<>(Todo.class));
    }
}
