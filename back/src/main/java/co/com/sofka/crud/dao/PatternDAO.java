package co.com.sofka.crud.dao;

import co.com.sofka.crud.entities.Todo;

public interface PatternDAO {
    Iterable<Todo> list();
    Todo save(Todo todo);
    void delete(Long id);
    Todo get(Long id);
}
