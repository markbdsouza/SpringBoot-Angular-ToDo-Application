package com.marksample.trustfulwebservice.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoResource {

    @Autowired
    private ToDoHardCodedService  toDoHardCodedService;

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllToDo(@PathVariable String username){
        return toDoHardCodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ToDo getToDo(@PathVariable String username, @PathVariable long id){
        return toDoHardCodedService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{todosID}")
    public ResponseEntity<ToDo> UpdateToDo(@PathVariable String username, @PathVariable Long todosID, @RequestBody ToDo todo){
        toDoHardCodedService.saveById(todo);
        return new ResponseEntity<ToDo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> CreateToDo(@PathVariable String username, @RequestBody ToDo todo){
        ToDo newTodo = toDoHardCodedService.saveById(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{username}/todos/{todosID}")
    public ResponseEntity<Void> DeleteToDo(@PathVariable String username, @PathVariable Long todosID){
        ToDo toDo = toDoHardCodedService.deleteToDoById(todosID);
        if(toDo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
