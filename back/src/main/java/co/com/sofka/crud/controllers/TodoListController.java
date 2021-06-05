package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.TodoList;
import co.com.sofka.crud.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Validated
@RestController
@RequestMapping("/api")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping(value = "api/tasklist")
    public Iterable<TodoList> list(){
        return todoListService.list();
    }

    @PostMapping(value = "api/tasklist")
    public TodoList save(@RequestBody TodoList todoList){
        return todoListService.save(todoList);
    }

    @PutMapping(value = "api/tasklist")
    public TodoList update(@RequestBody TodoList todoList){
        if(todoList.getTodo() != null){
            return todoListService.save(todoList);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/tasklist")
    public void delete(@PathVariable("id")Long idList){
        todoListService.delete(idList);
    }

    @NotEmpty(message = "No puede contener elementos vacios")
    @GetMapping(value = "api/{id}/tasklist")
    public TodoList get(@PathVariable("id") Long idList){
        return todoListService.get(idList);
    }
}
