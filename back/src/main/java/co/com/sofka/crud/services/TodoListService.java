package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TodoList;
import co.com.sofka.crud.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository listRepository;

    public Iterable<TodoList> list(){
        return listRepository.findAll();
    }

    public TodoList save(TodoList todoList){
        return listRepository.save(todoList);
    }

    public void delete(Long idlist){
        listRepository.delete(get(idlist));
    }

    public TodoList get(Long idlist){
        return listRepository.findById(idlist).orElseThrow();
    }

}
