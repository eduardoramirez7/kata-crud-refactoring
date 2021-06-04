package co.com.sofka.crud.dto;

import co.com.sofka.crud.entities.Todo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class TodoListDTO {
    private Long id;
    private String name;
    private Set<Todo> items = new HashSet<>();

    public TodoListDTO(){
        super();
    }
    public TodoListDTO(Long id, String name, Set<Todo> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Todo> getItems() {
        return items;
    }

    public void setItems(Set<Todo> items) {
        this.items = items;
    }
}
