package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8080/api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }


    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
