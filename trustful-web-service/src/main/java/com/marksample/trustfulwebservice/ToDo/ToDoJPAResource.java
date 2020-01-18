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
public class ToDoJPAResource {

    @Autowired
    private ToDoHardCodedService  toDoHardCodedService;

    @Autowired
    private ToDoJPARepository toDoJPARepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<ToDo> getAllToDo(@PathVariable String username){
        return toDoJPARepository.findByUsername(username);
//        return toDoHardCodedService.findAll();
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public ToDo getToDo(@PathVariable String username, @PathVariable long id){
        return toDoJPARepository.findById(id).get();
//        return toDoHardCodedService.findById(id);
    }

    @PutMapping("/jpa/users/{username}/todos/{todosID}")
    public ResponseEntity<ToDo> UpdateToDo(@PathVariable String username, @PathVariable Long todosID, @RequestBody ToDo todo){
//        toDoHardCodedService.saveById(todo);
        toDoJPARepository.save(todo);
        return new ResponseEntity<ToDo>(todo, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> CreateToDo(@PathVariable String username, @RequestBody ToDo todo){
//        ToDo newTodo = toDoHardCodedService.saveById(todo);
        todo.setUsername(username);
        ToDo newTodo = toDoJPARepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/jpa/users/{username}/todos/{todosID}")
    public ResponseEntity<Void> DeleteToDo(@PathVariable String username, @PathVariable Long todosID){
//        ToDo toDo = toDoHardCodedService.deleteToDoById(todosID);
        toDoJPARepository.deleteById(todosID);
//        if(toDo!=null){
            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
    }

}
