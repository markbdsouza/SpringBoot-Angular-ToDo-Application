package com.marksample.trustfulwebservice.ToDo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoHardCodedService {
    private static List<ToDo> todos= new ArrayList<ToDo>();
    private static Long idCounter = 0L;
    static {
        todos.add(new ToDo(++idCounter, "mark","Learn to dance", new Date(),false));
        todos.add(new ToDo(++idCounter, "mark","Learn microservices", new Date(),false));
        todos.add(new ToDo(++idCounter, "mark","Play sports", new Date(),false));
    }

    public List<ToDo> findAll(){
        return todos;
    }

    public ToDo deleteToDoById(Long id){
        ToDo todo = findById(id);
        if(todo==null) {
            return null;
        }else {
        todos.remove(todo);
        return todo;}

    }

    public ToDo findById(Long id){
        for(ToDo toDo:todos){
            if (toDo.getId() == id)
            {return  toDo; }
        }
        return null;
    }

    public ToDo saveById(ToDo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else {
            deleteToDoById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
