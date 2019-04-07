package pl.edu.wszib.todolist.springtodolist.service;

import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;

import java.util.List;

public interface TodoService {

    List<TodoDTO> findAll();
    TodoDTO find(Integer id);
    TodoDTO save(TodoDTO todoDTO);
    TodoDTO update(TodoDTO todoDTO);
    TodoDTO remove(Integer id);

    List<TodoDTO> upcomming();
    List<TodoDTO> search(Status status);
    int count(Status status);
}
