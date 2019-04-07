package pl.edu.wszib.todolist.springtodolist.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.todolist.springtodolist.dao.TodoDao;
import pl.edu.wszib.todolist.springtodolist.dto.TodoDTO;
import pl.edu.wszib.todolist.springtodolist.model.Status;
import pl.edu.wszib.todolist.springtodolist.model.Todo;
import pl.edu.wszib.todolist.springtodolist.service.TodoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao dao;

    @Autowired
    private Mapper mapper;

    @Override
    public List<TodoDTO> findAll() {
        return dao.findAll()
                .stream()
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDTO find(Integer id) {
        return dao.findById(id)
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .orElse(null);
    }

    @Override
    public TodoDTO save(TodoDTO todoDTO) {
        todoDTO.setStatus(Status.NEW);
        return Optional.of(dao.save(mapper.map(todoDTO, Todo.class)))
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .orElse(null);
    }

    @Override
    public TodoDTO update(TodoDTO todoDTO) {
        return Optional.of(dao.save(mapper.map(todoDTO, Todo.class)))
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .orElse(null);
    }

    @Override
    public TodoDTO remove(Integer id) {
        Optional<Todo> optionalTodo = dao.findById(id);
        optionalTodo.ifPresent(todo -> dao.delete(todo));
        return optionalTodo
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .orElse(null);
    }

    @Override
    public List<TodoDTO> upcomming() {
        return dao.findTop5ByStatusIsNotOrderByDueDateAsc(Status.COMPLETED)
                .stream()
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDTO> search(Status status) {
        return dao.findAllByStatus(status)
                .stream()
                .map(todo -> mapper.map(todo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int count(Status status) {
        return dao.countAllByStatus(status);
    }

}
