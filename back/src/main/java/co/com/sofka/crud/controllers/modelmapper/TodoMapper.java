package co.com.sofka.crud.controllers.modelmapper;

import co.com.sofka.crud.dto.TodoListDTO;
import co.com.sofka.crud.entities.Todo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name")
    })

    TodoListDTO toTodoDTO (Todo todo);
    Iterable<TodoListDTO> toTodoDTOs (Iterable<Todo> todos);

    @InheritInverseConfiguration
    Todo toTodo(TodoListDTO todolistDTO);
}
